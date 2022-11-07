package com.example.bookshelf.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.data.BooksApi
import com.example.bookshelf.model.Book
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BooksUiState {
    data class Success(val books: List<Book>) : BooksUiState
    object Error : BooksUiState
    object Loading : BooksUiState
}

class BooksViewModel : ViewModel() {

    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            booksUiState = try {
                val bookResult = BooksApi.retrofitService.getBooks()
                val books = mutableListOf<Book>()
                for (item in bookResult.items) {
                    val book = BooksApi.retrofitService.getBook(item.id)
                    book.volumeInfo.imageLinks.thumbnail = book.volumeInfo.imageLinks.thumbnail.replace("http", "https")
                    books.add(book)
                }
                BooksUiState.Success(books)
            } catch (e: IOException) {
                Log.e("IOException", e.message!!)
                BooksUiState.Error
            } catch (e: HttpException) {
                Log.e("Http Exception", e.message!!)
                BooksUiState.Error
            }
        }
    }

}