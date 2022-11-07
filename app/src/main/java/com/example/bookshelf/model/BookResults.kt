package com.example.bookshelf.model

@kotlinx.serialization.Serializable
data class BookResults(
    val kind: String,
    val totalItems: Int,
    val items: List<Book>
)
