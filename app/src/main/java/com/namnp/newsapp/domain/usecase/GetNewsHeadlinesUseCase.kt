package com.namnp.newsapp.domain.usecase

import com.namnp.newsapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
}