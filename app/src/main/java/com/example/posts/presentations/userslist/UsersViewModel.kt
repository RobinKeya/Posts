package com.example.posts.presentations.userslist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.data.PostsRepository
import com.example.posts.data.di.IODispatcher
import com.example.posts.data.di.MainDispatcher
import com.example.posts.data.remote.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class UsersViewModel @Inject constructor(
    private val repository: PostsRepository,
    @MainDispatcher private  val dispatcher : CoroutineDispatcher
): ViewModel() {
    private val _state = mutableStateOf(
        UsersScreenState(
            users = emptyList(),
            isLoading = true
        )
    )
    val state get() = _state

    private val exception = CoroutineExceptionHandler{_,err->
        _state.value = _state.value.copy(
            users = emptyList(),
            isLoading = false,
            error = err.message
        )
    }

    init {
        viewModelScope.launch(exception + dispatcher) {
            val users = getUsers()
            _state.value = _state.value.copy(
                users = users,
                isLoading = false
            )
        }
    }

    suspend fun getUsers(): List<User>{
        return repository.getUsers()
    }
}