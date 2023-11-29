package com.assignment.data.mapper

import com.assignment.data.dto.ProductionCompanyDto
import com.assignment.domain.modal.ProductionCompanyDomainModel
import javax.inject.Inject

class ProductionCompaniesDataToDomainMapper @Inject constructor() {
    operator fun invoke(dataModel: ProductionCompanyDto): ProductionCompanyDomainModel {
        return ProductionCompanyDomainModel(
            id = dataModel.id,
            name = dataModel.name,
        )
    }
}
