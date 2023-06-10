package com.namnp.newsapp.data.data_source

import com.namnp.newsapp.data.api.NewsAPIService
import com.namnp.newsapp.data.model.APIResponse
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int,
) : NewsRemoteDataSource {

    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }
}