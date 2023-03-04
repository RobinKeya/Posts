package com.example.posts.presentations.userDetails.userAlbum

import com.example.posts.data.remote.Album

data class AlbumScreenState(
    val albums : List<Album>,
    val isLoading: Boolean,
    val error : String? = null
)