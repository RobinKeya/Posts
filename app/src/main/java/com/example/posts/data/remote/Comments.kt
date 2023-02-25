package com.example.posts.data.remote

data class Comments(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)