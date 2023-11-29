package com.assignment.data.repository

import com.assignment.data.mapper.MovieListDataToDomainMapper
import com.assignment.data.remote.MovieService
import com.assignment.data.utils.safeApiCall
import com.assignment.domain.modal.MovieListDomainModel
import com.assignment.domain.repository.MovieListRepository
import com.assignment.domain.utils.Result
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieListMapper: MovieListDataToDomainMapper,
) : MovieListRepository {
    override suspend fun getMoviesList(): Result<MovieListDomainModel> =
        safeApiCall(
            apiCall = {
                movieService.getMoviesList()
            },
            dataMapper = {
                movieListMapper(it)
            },
        )
}
