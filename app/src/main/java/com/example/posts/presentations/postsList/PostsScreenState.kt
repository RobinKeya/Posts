package com.example.posts.presentations.postsList

import com.example.posts.data.remote.Post

data class PostsScreenState(
    val posts : List<Post>,
    val isLoading: Boolean,
    val error: String? = null
)
