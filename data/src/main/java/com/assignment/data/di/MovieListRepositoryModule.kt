package com.assignment.data.di

import com.assignment.data.repository.MovieListRepositoryImpl
import com.assignment.domain.repository.MovieListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieListRepositoryModule {

    @Binds
    abstract fun provideMovieRepository(movieListRepositoryImpl: MovieListRepositoryImpl): MovieListRepository
}
