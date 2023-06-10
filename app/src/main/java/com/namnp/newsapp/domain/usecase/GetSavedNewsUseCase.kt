package com.namnp.newsapp.domain.usecase

import com.namnp.newsapp.data.model.Article
import com.namnp.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }

//    fun execute() = flow {
//        emit(newsRepository.getSavedNews())
//    }
}