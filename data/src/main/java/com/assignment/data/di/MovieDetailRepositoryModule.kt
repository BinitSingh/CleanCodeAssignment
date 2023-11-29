package com.assignment.data.di

import com.assignment.data.repository.MovieDetailRepositoryImpl
import com.assignment.domain.repository.MovieDetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieDetailRepositoryModule {

    @Binds
    abstract fun provideMovieRepository(
        movieDetailRepositoryImpl: MovieDetailRepositoryImpl
    ): MovieDetailRepository
}
