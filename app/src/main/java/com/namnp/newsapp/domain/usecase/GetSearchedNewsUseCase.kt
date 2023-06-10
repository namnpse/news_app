package com.namnp.newsapp.domain.usecase

import com.namnp.newsapp.data.model.APIResponse
import com.namnp.newsapp.data.util.Resource
import com.namnp.newsapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}