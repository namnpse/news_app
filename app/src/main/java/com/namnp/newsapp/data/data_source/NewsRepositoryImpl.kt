package com.namnp.newsapp.data.data_source

import com.namnp.newsapp.data.model.APIResponse
import com.namnp.newsapp.data.model.Article
import com.namnp.newsapp.data.util.Resource
import com.namnp.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
) : NewsRepository {

    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return handleApiResponse(newsRemoteDataSource.getTopHeadlines(country, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return handleApiResponse(newsRemoteDataSource.getSearchedNews(country, searchQuery, page))
    }

    override suspend fun saveNews(article: Article) {
        TODO()
    }

    override suspend fun deleteSavedNews(article: Article) {
        TODO()
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO()
    }

    private fun handleApiResponse(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}