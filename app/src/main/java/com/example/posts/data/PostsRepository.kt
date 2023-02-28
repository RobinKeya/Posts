package com.example.posts.data

import com.example.posts.data.di.IODispatcher
import com.example.posts.data.remote.Post
import com.example.posts.data.remote.PostsInterface
import com.example.posts.data.remote.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val postsInterface: PostsInterface,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend fun getPosts(): List<Post>{
        return withContext(dispatcher){
            return@withContext postsInterface.getPosts()
        }
    }
    suspend fun getPost(id: Int): Post{
        return  withContext(dispatcher){
            return@withContext postsInterface.getPost(id)
        }
    }
    suspend fun getUsers(): List<User>{
        return withContext(dispatcher){
            return@withContext postsInterface.getUsers()
        }
    }
}