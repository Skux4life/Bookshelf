package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val imageLinks: ImageLinks
)
