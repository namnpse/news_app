package com.namnp.newsapp.data.model


import com.google.gson.annotations.SerializedName
import com.namnp.newsapp.domain.entity.ArticleEntity
import com.namnp.newsapp.domain.entity.SourceEntity

data class Source(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)

fun Source.toEntity(): SourceEntity {
    return SourceEntity(
        id = id,
        name = name,
    )
}