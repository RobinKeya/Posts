package com.example.posts.data

import com.example.posts.data.di.IODispatcher
import com.example.posts.data.remote.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
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
    suspend fun getUser(id: Int): User{
        return withContext(dispatcher){
            return@withContext postsInterface.getUser(id)
        }
    }

    suspend fun getTodos(userId: Int): List<Todo>{
        return withContext(dispatcher){
            return@withContext postsInterface.getTodos(userId)
        }
    }

    suspend fun getPosts(userId: Int): List<Post>{
        return withContext(dispatcher){
            return@withContext postsInterface.getPosts(userId)
        }
    }

    suspend fun getAlbums(userId: Int): List<Album>{
        return withContext(dispatcher){
            return@withContext postsInterface.getAlbums(userId)
        }
    }

}