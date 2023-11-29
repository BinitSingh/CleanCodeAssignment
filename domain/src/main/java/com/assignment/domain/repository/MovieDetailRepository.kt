package com.assignment.domain.repository

import com.assignment.domain.modal.MovieDetailsDomainModel
import com.assignment.domain.utils.Result

interface MovieDetailRepository {
    suspend fun getMovieDetails(movieId: String): Result<MovieDetailsDomainModel>
}
