package com.namnp.newsapp.di

import com.namnp.newsapp.data.data_source.NewsLocalDataSource
import com.namnp.newsapp.data.data_source.NewsRemoteDataSource
import com.namnp.newsapp.data.repository.NewsRepositoryImpl
import com.namnp.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource,
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }
}