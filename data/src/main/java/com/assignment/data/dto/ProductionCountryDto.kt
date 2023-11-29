package com.assignment.data.dto

import com.squareup.moshi.Json

data class ProductionCountryDto(

    @Json(name = "iso_3166_1")
    val iso31661: String,

    @Json(name = "name")
    val name: String,

)
