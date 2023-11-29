package com.assignment.data.mapper

import com.assignment.data.dto.MovieResultDto
import com.assignment.domain.modal.MovieResultDomainModel
import javax.inject.Inject

class MovieResultDataToDomainMapper @Inject constructor() {
    operator fun invoke(dataModel: MovieResultDto): MovieResultDomainModel {
        return MovieResultDomainModel(
            id = dataModel.id,
            posterPath = dataModel.posterPath,
            title = dataModel.title,
        )
    }
}
