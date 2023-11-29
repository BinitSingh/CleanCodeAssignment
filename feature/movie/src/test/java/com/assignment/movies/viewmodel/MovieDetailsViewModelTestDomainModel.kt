package com.assignment.movies.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.assignment.domain.modal.MovieDetailsDomainModel
import com.assignment.domain.usecase.MovieDetailsUseCase
import com.assignment.domain.utils.Result
import com.assignment.movies.core.CoroutineRule
import com.assignment.movies.ui.UiEvent
import com.assignment.movies.ui.details.viewModel.MovieDetailState
import com.assignment.movies.ui.details.viewModel.MoviesDetailViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@OptIn(ExperimentalCoroutinesApi::class)
class MovieDetailsViewModelTestDomainModel {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = CoroutineRule()

    private lateinit var viewModel: MoviesDetailViewModel

    private val movieDetailsUseCase: MovieDetailsUseCase = mockk()

    private val savedState = SavedStateHandle(mapOf(MOVIE_KEY to MOVIE_ID))

    @Before
    fun setUp() {
        viewModel = MoviesDetailViewModel(movieDetailsUseCase, savedStateHandle = savedState)
    }

    @Test
    fun `fetch movie detail loading success test`() {
        coEvery {
            movieDetailsUseCase(MOVIE_ID)
        } returns Result.Success(MovieDetailsDomainModel())

        runTest {
            viewModel.onEvent(UiEvent.InitState)
            assert(viewModel.movieDetailsState.value is MovieDetailState.OnMovieDetailSuccess)
        }
    }

    @Test
    fun `fetch movie detail error failure test`() {
        coEvery {
            movieDetailsUseCase(MOVIE_ID)
        } returns Result.Error(errorMessage = EMPTY_STRING)

        runTest {
            viewModel.onEvent(UiEvent.InitState)
            assert(viewModel.movieDetailsState.value is MovieDetailState.OnMovieDetailFailure)
        }
    }

    @Test
    fun `fetch movie detail exception failure test`() {
        coEvery {
            movieDetailsUseCase(MOVIE_ID)
        } returns Result.Exception(Exception(EMPTY_LIST))

        runTest {
            viewModel.onEvent(UiEvent.InitState)
            assert(viewModel.movieDetailsState.value is MovieDetailState.OnMovieDetailFailure)
        }
    }

    private companion object {
        const val MOVIE_ID = "1"
        const val MOVIE_KEY = "movieId"
        const val EMPTY_LIST = "Empty list"
        const val EMPTY_STRING = ""
    }
}
