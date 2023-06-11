package com.namnp.newsapp.domain.usecase

import com.namnp.newsapp.data.model.APIResponse
import com.namnp.newsapp.data.util.Resource
import com.namnp.newsapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int): Resource<APIResponse> {
//        don’t have to always return the same value taken from the repository.
//        could actually code some business logic here.
//        could get some data from the repository, modify it and return as another type.
//        But for this scenario, no business required, just return the data taken from the repository.
        return newsRepository.getNewsHeadlines(country, page)
    }
}