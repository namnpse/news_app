package com.namnp.newsapp.domain.usecase

import com.namnp.newsapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
}