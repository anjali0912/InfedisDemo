package com.example.infedisdemo.data.news

data class NewsModel(
    val articles: List<Article>,
    val status: String? = "",
    val totalResults: Int? = -1
)