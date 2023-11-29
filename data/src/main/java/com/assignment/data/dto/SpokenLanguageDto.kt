package com.assignment.data.dto

import com.squareup.moshi.Json

data class SpokenLanguageDto(
    @Json(name = "english_name")
    val englishName: String,

    @Json(name = "iso_639_1")
    val iso6391: String,

    @Json(name = "name")
    val name: String,
)