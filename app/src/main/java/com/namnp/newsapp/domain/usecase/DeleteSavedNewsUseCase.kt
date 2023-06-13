package com.namnp.newsapp.domain.usecase

import com.namnp.newsapp.data.model.Article
import com.namnp.newsapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteSavedNews(article)
}