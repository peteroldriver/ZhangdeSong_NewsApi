package com.petersong.zhangdesong_newsapi.Model

import com.petersong.zhangdesong_newsapi.Model.Article

data class News (
    val articles: List<Article>,
    val status: String?,
    val totalResults: Int?
)

data class Article (
    var author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)

data class Source(
    val id: String?,
    val name: String?
)