package com.namnp.newsapp.data.data_source

import com.namnp.newsapp.data.api.NewsAPIService
import com.namnp.newsapp.data.model.APIResponse
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
) : NewsRemoteDataSource {

    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }
}