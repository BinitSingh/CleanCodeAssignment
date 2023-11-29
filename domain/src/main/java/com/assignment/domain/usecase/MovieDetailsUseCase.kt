package com.assignment.domain.usecase

import com.assignment.domain.modal.MovieDetailsDomainModel
import com.assignment.domain.repository.MovieDetailRepository
import com.assignment.domain.utils.Result
import javax.inject.Inject

open class MovieDetailsUseCase @Inject constructor(private val movieDetailRepository: MovieDetailRepository) {
    suspend operator fun invoke(movieId: String): Result<MovieDetailsDomainModel> =
        movieDetailRepository.getMovieDetails(movieId)
}
