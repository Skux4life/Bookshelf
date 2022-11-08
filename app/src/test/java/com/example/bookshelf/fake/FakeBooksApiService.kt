package com.example.bookshelf.fake

import com.example.bookshelf.data.BooksApiService
import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookResults

class FakeBooksApiService : BooksApiService {
    override suspend fun getBooks(): BookResults {
        return FakeDataSource.bookResults
    }

    override suspend fun getBook(id: String): Book {
        return FakeDataSource.bookResults.items.find {
            it.id == id
        }!!
    }

}