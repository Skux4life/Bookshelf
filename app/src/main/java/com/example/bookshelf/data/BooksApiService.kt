package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookResults
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://www.googleapis.com/books/v1/"
private val json = Json { ignoreUnknownKeys = true }

private val retrofit = Retrofit.Builder()
    .addConverterFactory(json
        .asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface BooksApiService {
    @GET("volumes?=Pele")
    suspend fun getBooks(): BookResults

    @GET("volumes/24yRRvkgsc8C")
    suspend fun getBook(): Book
}

object BooksApi {
    val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
}