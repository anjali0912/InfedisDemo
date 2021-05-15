package com.example.infedisdemo.data.books

data class BooksModel(
    val items: List<Item>,
    val kind: String?= "",
    val totalItems: Int?= -1
)