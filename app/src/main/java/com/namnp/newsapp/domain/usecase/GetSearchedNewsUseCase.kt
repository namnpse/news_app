package com.namnp.newsapp.domain.usecase

import com.namnp.newsapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}