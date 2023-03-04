package com.example.posts.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PostsInterface {
    @GET("/posts")
    suspend fun getPosts():List<Post>
    @GET("/posts/{id}")
    suspend fun getPost(id: Int): Post

    @GET("/users")
    suspend fun getUsers(): List<User>

    @GET("/users/{id}")
    suspend fun getUser(id: Int): User

    @GET("/users/{id}/todos")
    suspend fun getTodos(id: Int): List<Todo>

    @GET("/users/{id}/albums")
    suspend fun getAlbums(id:Int): List<Album>

    @GET("/albums/{id}/photos")
    suspend fun getPhotos(id:Int): List<Photo>

    @GET("/users/{id}/posts")
    suspend fun getPosts(id: Int): List<Post>
}