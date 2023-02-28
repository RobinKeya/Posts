package com.example.posts.presentations.postDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.data.PostsRepository
import com.example.posts.data.di.IODispatcher
import com.example.posts.data.remote.Post
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostDetailsViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private  val repository: PostsRepository
): ViewModel() {
    private val _state = mutableStateOf<Post?>(null)
    val state get() = _state

    init {
        val id = stateHandle.get<Int>("post_id")?:0
        viewModelScope.launch (dispatcher){
            val post =getRestaurant(id)
            _state.value = post
        }
    }
    suspend fun getRestaurant(id: Int): Post{
        return withContext(dispatcher){
            val post = repository.getPost(id)
            return@withContext post
        }
    }
}