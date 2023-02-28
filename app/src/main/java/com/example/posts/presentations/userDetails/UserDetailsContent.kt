package com.example.posts.presentations.userDetails

import androidx.annotation.DrawableRes

data class UserDetailsContent(
    val id: Int,
    val title: String,
    @DrawableRes val icon: Int
)
