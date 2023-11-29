package com.assignment.data.dto.repository

import com.assignment.data.dto.MovieListResponseDto
import com.assignment.data.mapper.MovieListDataToDomainMapper
import com.assignment.data.remote.MovieService
import com.assignment.data.repository.MovieListRepositoryImpl
import com.assignment.domain.modal.MovieListDomainModel
import com.assignment.domain.utils.Result
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import java.net.UnknownHostException

@RunWith(MockitoJUnitRunner::class)
class MovieListRepositoryImplTest {

    private lateinit var movieListRepository: MovieListRepositoryImpl
    private val movieService = mockk<MovieService>()
    private val mockkMovieListDataToDomainMapper = mockk<MovieListDataToDomainMapper>()

    @Before
    fun setUp() {
        movieListRepository =
            MovieListRepositoryImpl(movieService, mockkMovieListDataToDomainMapper)
    }

    @Test
    fun `fetch movie list success test`() {
        val mockHttpMovieListResponseDto = mockk<Response<MovieListResponseDto>>()
        val mockMovieListResponseDto = mockk<MovieListResponseDto>()
        val mockMovieListDomainModel = mockk<MovieListDomainModel>()

        every {
            mockHttpMovieListResponseDto.isSuccessful
        } returns true

        every {
            mockHttpMovieListResponseDto.body()
        } returns mockMovieListResponseDto

        every {
            mockkMovieListDataToDomainMapper(mockHttpMovieListResponseDto.body()!!)
        } returns mockMovieListDomainModel

        coEvery {
            movieService.getMoviesList()
        } returns mockHttpMovieListResponseDto

        runTest {
            val result = movieListRepository.getMoviesList()
            assert(result is Result.Success)
        }
    }

    @Test
    fun `fetch movie list api error failure test`() {
        val mockHttpMovieListResponse = mockk<Response<MovieListResponseDto>>()
        every {
            mockHttpMovieListResponse.isSuccessful
        } returns false

        every {
            mockHttpMovieListResponse.message()
        } returns SERVER_ERROR

        coEvery {
            movieService.getMoviesList()
        } returns mockHttpMovieListResponse

        runTest {
            val result = movieListRepository.getMoviesList()
            assert(result is Result.Error)
        }
    }

    @Test
    fun `fetch movie list empty body failure test`() {
        val mockHttpMovieListResponse = mockk<Response<MovieListResponseDto>>()
        every {
            mockHttpMovieListResponse.isSuccessful
        } returns true

        every {
            mockHttpMovieListResponse.body()
        } returns null

        coEvery {
            movieService.getMoviesList()
        } returns mockHttpMovieListResponse

        runTest {
            val result = movieListRepository.getMoviesList()
            assert(result is Result.Error)
        }
    }

    @Test
    fun `fetch movie list network throws exception failure test`() {
        coEvery {
            movieService.getMoviesList()
        } throws UnknownHostException()

        runTest {
            val result = movieListRepository.getMoviesList()
            assert(result is Result.Exception)
        }
    }

    private companion object {
        const val SERVER_ERROR = "Server not responding"
    }
}
