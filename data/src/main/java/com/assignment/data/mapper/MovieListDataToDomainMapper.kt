package com.assignment.data.mapper

import com.assignment.data.dto.MovieListResponseDto
import com.assignment.domain.modal.MovieListDomainModel
import javax.inject.Inject

class MovieListDataToDomainMapper @Inject constructor(
    private val movieResultDataToDomainMapper: MovieResultDataToDomainMapper,
) {
    operator fun invoke(dataModel: MovieListResponseDto): MovieListDomainModel {
        return MovieListDomainModel(
            results = dataModel.results.map { movieResultDataToDomainMapper.invoke(it) },
        )
    }
}
