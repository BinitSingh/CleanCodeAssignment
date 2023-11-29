package com.assignment.movies.ui.details.viewModel

import com.assignment.domain.modal.MovieDetailsDomainModel

sealed interface MovieDetailState {
    data object Loading : MovieDetailState
    data class OnMovieDetailSuccess(val response: MovieDetailsDomainModel) : MovieDetailState
    data class OnMovieDetailFailure(val message: String) : MovieDetailState
}
