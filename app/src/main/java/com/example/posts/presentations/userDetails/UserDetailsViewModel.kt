package com.example.posts.presentations.userDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.data.PostsRepository
import com.example.posts.data.di.IODispatcher
import com.example.posts.data.di.MainDispatcher
import com.example.posts.data.remote.Album
import com.example.posts.data.remote.Post
import com.example.posts.data.remote.Todo
import com.example.posts.data.remote.User
import com.example.posts.presentations.postsList.PostsScreenState
import com.example.posts.presentations.userDetails.userAlbum.AlbumScreenState
import com.example.posts.presentations.userDetails.userTodo.TodoScreenState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserDetailsViewModel @Inject constructor(
    private val repository: PostsRepository,
    @MainDispatcher private val dispater: CoroutineDispatcher,
    stateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<User?>(null)
    val state get() = _state

    private val _todoState = mutableStateOf(
        TodoScreenState(
            todos = listOf(),
            isLoading = true
        )
    )
    val todoState get() = _todoState

    private val _userPosts = mutableStateOf(
        PostsScreenState(
            posts = emptyList(),
            isLoading = true
        )
    )
    val userPosts get() = _userPosts

    private val _userAlbums = mutableStateOf(
        AlbumScreenState(
            albums = emptyList(),
            isLoading = true
        )
    )
    val userAlbums get() = _userAlbums

    init {
        val id = stateHandle.get<Int?>("user_id")?:0
        viewModelScope.launch(dispater) {
            val user =getUser(id)
            val todos = getTodos(id)
            val posts = getPosts(id)
            val albums = getAlbums(id)
            _state.value = user
            _todoState.value = _todoState.value.copy(
                todos = todos,
                isLoading = false
            )
            _userPosts.value = _userPosts.value.copy(
                posts = posts,
                isLoading = false
            )
            _userAlbums.value = _userAlbums.value.copy(
                albums = albums,
                isLoading = false
            )
        }
    }

    private suspend fun getUser(id: Int): User {
        return repository.getUser(id)
    }
    //todo
    //seek clarification
    private suspend fun getTodos(userId: Int): List<Todo>{
        return repository.getTodos(userId)
    }

   private suspend fun getPosts(userId: Int): List<Post>{
        return repository.getPosts(userId)
    }

    private suspend fun getAlbums(userId: Int): List<Album>{
        return repository.getAlbums(userId)
    }
}
