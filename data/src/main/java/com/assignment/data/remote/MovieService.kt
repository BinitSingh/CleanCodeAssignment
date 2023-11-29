package com.assignment.data.remote

import com.assignment.data.BuildConfig
import com.assignment.data.dto.MovieDetailResponseDto
import com.assignment.data.dto.MovieListResponseDto
import com.assignment.data.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getMoviesList(
        @Query("api_key") apiKey: String = BuildConfig.APIKEY,
        @Query("language") language: String = Constants.LANGUAGE,
        @Query("page") page: Long = 1,
    ): Response<MovieListResponseDto>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String = BuildConfig.APIKEY,
        @Query("language") language: String = Constants.LANGUAGE,
    ): Response<MovieDetailResponseDto>
}
