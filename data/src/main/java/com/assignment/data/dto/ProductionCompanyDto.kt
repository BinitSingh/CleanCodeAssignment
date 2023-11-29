package com.assignment.data.dto

import com.squareup.moshi.Json

data class ProductionCompanyDto(
    @Json(name = "id")
    val id: Int,

    @Json(name = "logo_path")
    val logoPath: String?,

    @Json(name = "name")
    val name: String,

    @Json(name = "origin_country")
    val originCountry: String,

)
