package com.namnp.newsapp.domain.usecase

import com.namnp.newsapp.domain.entity.ArticleEntity
import com.namnp.newsapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: ArticleEntity) = newsRepository.saveNews(article)
}