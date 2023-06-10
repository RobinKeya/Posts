package com.example.posts.presentations.postsList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.data.PostsRepository
import com.example.posts.data.di.MainDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postsRepository: PostsRepository,
    @MainDispatcher private val dispatcher: CoroutineDispatcher
): ViewModel() {
    private  val _state = mutableStateOf(
        PostsScreenState(
            posts = listOf(),
            isLoading = true
        )
    )
    val state get() = _state

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _state.value = _state.value.copy(
            posts = listOf(), isLoading = false, error = throwable.message
        )
    }
    init {
        getPosts()
    }

    private fun getPosts(){
        viewModelScope.launch(dispatcher + exceptionHandler) {
            val posts = postsRepository.getPosts()
            _state.value = _state.value.copy(
                posts = posts,
                isLoading = false
            )
        }
    }
}