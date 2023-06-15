package com.namnp.newsapp.domain.usecase

import com.namnp.newsapp.domain.entity.ArticleEntity
import com.namnp.newsapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: ArticleEntity) = newsRepository.deleteSavedNews(article)
}