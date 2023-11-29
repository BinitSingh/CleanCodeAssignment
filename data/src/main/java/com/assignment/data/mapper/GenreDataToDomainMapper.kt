package com.assignment.data.mapper

import com.assignment.data.dto.GenreDto
import com.assignment.domain.modal.GenreDomainModel
import javax.inject.Inject

class GenreDataToDomainMapper @Inject constructor() {

    operator fun invoke(dataModel: GenreDto): GenreDomainModel {
        return GenreDomainModel(dataModel.id, dataModel.name)
    }
}
