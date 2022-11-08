package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookResults
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.VolumeInfo

object FakeDataSource {
    val book1 = Book(
        id = "2a",
        volumeInfo = VolumeInfo(
            ImageLinks(
                smallThumbnail = "img1small",
                thumbnail = "img1"
            )
        )
    )
    val book2 = Book(
        id = "3gf",
        volumeInfo = VolumeInfo(
            ImageLinks(
                smallThumbnail = "img2small",
                thumbnail = "img2"
            )
        )
    )
    val bookResults = BookResults(
        kind = "Books",
        totalItems = 100,
        items = listOf(book1, book2)
    )
}