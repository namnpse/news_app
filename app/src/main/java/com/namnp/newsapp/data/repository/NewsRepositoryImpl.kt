package com.namnp.newsapp.data.repository

import com.namnp.newsapp.data.data_source.NewsLocalDataSource
import com.namnp.newsapp.data.data_source.NewsRemoteDataSource
import com.namnp.newsapp.data.model.APIResponse
import com.namnp.newsapp.data.model.Article
import com.namnp.newsapp.data.model.Source
import com.namnp.newsapp.data.model.toEntity
import com.namnp.newsapp.data.util.Resource
import com.namnp.newsapp.domain.entity.ArticleEntity
import com.namnp.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
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

    override suspend fun saveNews(article: ArticleEntity) {
        newsLocalDataSource.saveArticleToDB(mapEntityToModel(article))
    }

    private fun mapEntityToModel(article: ArticleEntity): Article {
        return Article(
                id = article.id,
                author = article.author,
                content = article.content,
                description = article.description,
                publishedAt = article.publishedAt,
                source = if(article.source != null) Source(id = article.source.id, name = article.source.name) else null,
                title = article.title,
                url = article.url,
                urlToImage = article.urlToImage,
            )
    }

    override suspend fun deleteSavedNews(article: ArticleEntity) {
        newsLocalDataSource.deleteArticlesFromDB(mapEntityToModel(article))
    }

    override fun getSavedNews(): Flow<List<ArticleEntity>> {
        return newsLocalDataSource.getSavedArticles().map { data ->
            data.map { it.toEntity() }
        }
    }

    private fun handleApiResponse(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?. let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}