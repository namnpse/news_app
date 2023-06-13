package com.namnp.newsapp.di

import com.namnp.newsapp.data.api.NewsAPIService
import com.namnp.newsapp.data.data_source.NewsLocalDataSource
import com.namnp.newsapp.data.data_source.NewsLocalDataSourceImpl
import com.namnp.newsapp.data.data_source.NewsRemoteDataSource
import com.namnp.newsapp.data.data_source.NewsRemoteDataSourceImpl
import com.namnp.newsapp.data.db.ArticleDAO
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

    @Singleton
    @Provides
    fun provideNewsLocalDataSource(newsDAO: ArticleDAO): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(newsDAO)
    }
}