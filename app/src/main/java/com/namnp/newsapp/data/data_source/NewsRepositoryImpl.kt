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

    override suspend fun getNewsHeadlines(): Resource<APIResponse> {
        return handleApiResponse(newsRemoteDataSource.getTopHeadlines())
    }

    override suspend fun getSearchedNews(
        searchQuery: String,
    ): Resource<APIResponse> {
        TODO()
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