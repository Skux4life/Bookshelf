package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookResults

interface BooksRepository {
    suspend fun getBooks(): BookResults

    suspend fun getBook(id: String) : Book
}

class DefaultBooksRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {
    override suspend fun getBooks(): BookResults {
        return booksApiService.getBooks()
    }

    override suspend fun getBook(id: String): Book {
        return booksApiService.getBook(id)
    }

}