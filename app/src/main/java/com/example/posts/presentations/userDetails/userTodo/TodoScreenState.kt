package com.example.posts.presentations.userDetails.userTodo

import com.example.posts.data.remote.Todo

data class TodoScreenState(
    val todos : List<Todo>,
    val isLoading: Boolean,
    val error: String? = null
)
