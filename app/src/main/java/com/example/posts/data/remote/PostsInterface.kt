package com.example.posts.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostsInterface {
    @GET("/posts")
    suspend fun getPosts():List<Post>
    @GET("/posts/{id}")
    suspend fun getPost(@Path("id")id: Int): Post

    @GET("/users")
    suspend fun getUsers(): List<User>

    @GET("/users/{id}")
    suspend fun getUser(@Path("id")id: Int): User

    @GET("/users/{id}/todos")
    suspend fun getTodos(@Path("id")id: Int): List<Todo>

    @GET("/users/{id}/albums")
    suspend fun getAlbums(@Path("id")id:Int): List<Album>

    @GET("/albums/{id}/photos")
    suspend fun getPhotos(@Path("id")id:Int): List<Photo>

    @GET("/users/{id}/posts")
    suspend fun getPosts(@Path("id")id: Int): List<Post>
}