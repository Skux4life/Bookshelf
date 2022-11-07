package com.example.bookshelf

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.data.BooksApi
import com.example.bookshelf.model.BookResults
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BooksUiState {
    data class Success(val book: BookResults) : BooksUiState
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
                val book = BooksApi.retrofitService.getBooks()
                BooksUiState.Success(book)
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