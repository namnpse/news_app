package com.namnp.newsapp.domain.entity


import java.io.Serializable

data class ArticleEntity(
    val id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceEntity?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable