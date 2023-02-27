package com.example.posts.presentations.userDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.data.PostsRepository
import com.example.posts.data.di.IODispatcher
import com.example.posts.data.remote.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserDetailsViewModel @Inject constructor(
    private val repository: PostsRepository,
    @IODispatcher private val dispatcher : CoroutineDispatcher,
    private val stateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf<User?>(null)
    val state get() = _state

    init {
        val userId = stateHandle.get<Int?>("user_id")?:0
        viewModelScope.launch(dispatcher) {
            val user = getUser(userId)
            _state.value = user
        }
    }
    suspend fun getUser(id: Int): User{
        return withContext(dispatcher){
            val user = repository.getUser(id)
            return@withContext user
        }
    }
}