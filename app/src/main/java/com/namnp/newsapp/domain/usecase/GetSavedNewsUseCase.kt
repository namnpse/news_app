package com.namnp.newsapp.domain.usecase

import com.namnp.newsapp.domain.entity.ArticleEntity
import com.namnp.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<ArticleEntity>> {
        return newsRepository.getSavedNews()
    }

//    fun execute() = flow {
//        emit(newsRepository.getSavedNews())
//    }
}