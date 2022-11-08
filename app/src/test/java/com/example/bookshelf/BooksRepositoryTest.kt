package com.example.bookshelf

import com.example.bookshelf.data.DefaultBooksRepository
import com.example.bookshelf.fake.FakeBooksApiService
import com.example.bookshelf.fake.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class BooksRepositoryTest {

    @Test
    fun defaultBooksRepository_getBookResults_verifyResult() = runTest {
        val repository = DefaultBooksRepository(
            booksApiService = FakeBooksApiService()
        )
        assertEquals(FakeDataSource.bookResults, repository.getBooks())
    }

    @Test
    fun defaultBooksRepository_getBook_verifyResult() = runTest {
        val repository = DefaultBooksRepository(
            booksApiService = FakeBooksApiService()
        )
        assertEquals(FakeDataSource.book1, repository.getBook("2a"))
    }
}