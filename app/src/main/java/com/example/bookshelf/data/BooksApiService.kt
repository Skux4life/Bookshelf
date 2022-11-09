package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookResults
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApiService {
    @GET("volumes?q=Pele")
    suspend fun getBooks(): BookResults

    @GET("volumes/{id}")
    suspend fun getBook(@Path("id") id: String): Book
}
