package com.example.posts.presentations.userslist

import com.example.posts.data.remote.User

data class UsersScreenState(
    val users : List<User>,
    val isLoading : Boolean,
    val error : String? = null
    )
