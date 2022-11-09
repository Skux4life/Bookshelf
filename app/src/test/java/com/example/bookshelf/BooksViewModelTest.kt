package com.example.bookshelf

import com.example.bookshelf.fake.FakeBooksRepository
import com.example.bookshelf.fake.FakeDataSource
import com.example.bookshelf.rules.TestDispatcherRule
import com.example.bookshelf.ui.screens.BooksUiState
import com.example.bookshelf.ui.screens.BooksViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BooksViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun booksViewModel_getBooks_verifyBooksUiStateSuccess() = runTest {
        val booksViewModel = BooksViewModel(
            booksRepository = FakeBooksRepository()
        )
        assertEquals(BooksUiState.Success(FakeDataSource.bookResults.items), booksViewModel.booksUiState)
    }
}