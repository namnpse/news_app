package com.namnp.newsapp.domain.repository

//import androidx.lifecycle.LiveData
import com.namnp.newsapp.data.model.APIResponse
import com.namnp.newsapp.data.model.Article
import com.namnp.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadlines(): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteSavedNews(article: Article)
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>

    //    fun getSavedNews(article: Article): LiveData<List<Article>>
    //    work for most cases, but not recommended because:
    //    + it has lifecycle, should only be used in VM, observed in view) -> unexpected threading issues
    //    + In Clean, do not use Android framework related libs -> should not put LiveData (belong to Android) in Repo (domain)
    //    + can't be used in KMM when shared with iOS
    //    -> should use Flow ( Kotlin related classes)
    fun getSavedNews(): Flow<List<Article>>
}