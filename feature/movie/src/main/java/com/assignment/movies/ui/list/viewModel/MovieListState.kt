package com.assignment.movies.ui.list.viewModel

import com.assignment.domain.modal.MovieListDomainModel

sealed interface MovieListState {
    data object Loading : MovieListState
    data class OnMovieListSuccess(val response: MovieListDomainModel) : MovieListState
    data class OnMovieListFailure(val message: String) : MovieListState
}
