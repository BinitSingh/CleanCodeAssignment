package com.assignment.domain.usecase

import com.assignment.domain.modal.MovieListDomainModel
import com.assignment.domain.modal.MovieResultDomainModel
import com.assignment.domain.repository.MovieListRepository
import com.assignment.domain.utils.Result
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.net.UnknownHostException

class MovieListUseCaseTest {

    private val movieListRepository: MovieListRepository = mockk()
    private lateinit var movieListUseCase: MovieListUseCase

    @Before
    fun setUp() {
        movieListUseCase = MovieListUseCase(
            movieListRepository = movieListRepository,
        )
    }

    @Test
    fun `fetch movie list success test`() {
        val mockMovieResultDomainModel = mockk<MovieResultDomainModel>()
        val mockMovieListDomainModelResponse = mockk<MovieListDomainModel>()

        every {
            mockMovieListDomainModelResponse.results
        } returns listOf(mockMovieResultDomainModel)

        coEvery {
            movieListRepository.getMoviesList()
        } returns Result.Success(mockMovieListDomainModelResponse)

        runTest {
            val data = movieListUseCase()
            assert(data is Result.Success)
        }
    }

    @Test
    fun `fetch movie list failure test`() {
        coEvery {
            movieListRepository.getMoviesList()
        } returns Result.Error(API_ERROR)

        runTest {
            assert(movieListUseCase() is Result.Error)
        }
    }

    @Test
    fun `fetch movie list exception test`() {
        coEvery {
            movieListRepository.getMoviesList()
        } returns Result.Exception(UnknownHostException(UNKNOWN_ERROR))

        runTest {
            assert(movieListUseCase() is Result.Exception)
        }
    }
    private companion object {
        const val UNKNOWN_ERROR = "Unknown error"
        const val API_ERROR = "Empty list"
    }
}
