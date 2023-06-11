package com.namnp.newsapp.di

import com.namnp.newsapp.data.api.NewsAPIService
import com.namnp.newsapp.data.data_source.NewsRemoteDataSource
import com.namnp.newsapp.data.data_source.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsApiService: NewsAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }
}