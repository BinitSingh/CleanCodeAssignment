package com.assignment.data.repository

import com.assignment.data.mapper.MovieDetailsDataToDomainMapper
import com.assignment.data.remote.MovieService
import com.assignment.data.utils.safeApiCall
import com.assignment.domain.modal.MovieDetailsDomainModel
import com.assignment.domain.repository.MovieDetailRepository
import com.assignment.domain.utils.Result
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieDetailsMapper: MovieDetailsDataToDomainMapper,
) :
    MovieDetailRepository {

    override suspend fun getMovieDetails(movieId: String): Result<MovieDetailsDomainModel> =
        safeApiCall(
            apiCall = {
                movieService.getMovieDetails(movieId)
            },
            dataMapper = {
                movieDetailsMapper(it)
            },
        )
}
