package com.example.bookshelf

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
    data class Success(val book: Book) : BooksUiState
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
                val book = BooksApi.retrofitService.getBook()
                BooksUiState.Success(book)
            } catch (e: IOException) {
                BooksUiState.Error
            } catch (e: HttpException) {
                BooksUiState.Error
            }
        }
    }

}