package com.assignment.domain.repository

import com.assignment.domain.modal.MovieListDomainModel
import com.assignment.domain.utils.Result

interface MovieListRepository {
    suspend fun getMoviesList(): Result<MovieListDomainModel>
}
