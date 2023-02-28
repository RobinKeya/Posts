package com.example.posts.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PostsInterface {
    @GET("/posts")
    suspend fun getPosts(): List<Post>
    @GET("/posts/{id}")
    suspend fun getPost(@Query("id")id: Int): Post

    @GET("/users")
    suspend fun getUsers(): List<User>
}