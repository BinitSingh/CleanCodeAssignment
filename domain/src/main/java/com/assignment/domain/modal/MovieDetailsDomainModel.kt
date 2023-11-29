package com.assignment.domain.modal

import com.assignment.domain.utils.Constants

data class MovieDetailsDomainModel(
    val id: Int = 0,
    val title: String = Constants.EMPTY_STRING,
    val backdropPath: String = Constants.EMPTY_STRING,
    val genres: List<GenreDomainModel> = emptyList(),
    val overview: String = Constants.EMPTY_STRING,
    val productionCompanies: List<ProductionCompanyDomainModel> = emptyList(),
    val voteAverage: Double = 0.0,
    val voteCount: Long = 0,
)
