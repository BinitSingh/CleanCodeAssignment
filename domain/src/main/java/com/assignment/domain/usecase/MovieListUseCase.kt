package com.assignment.domain.usecase

import com.assignment.domain.modal.MovieListDomainModel
import com.assignment.domain.repository.MovieListRepository
import com.assignment.domain.utils.Result
import javax.inject.Inject

open class MovieListUseCase @Inject constructor(private val movieListRepository: MovieListRepository) {
    suspend operator fun invoke(): Result<MovieListDomainModel> =
        movieListRepository.getMoviesList()
}
