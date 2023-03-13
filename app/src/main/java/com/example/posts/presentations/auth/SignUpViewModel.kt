package com.example.posts.presentations.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {
    var userName = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("")


    private fun isEmpty(str: String): Boolean{
        return str.isBlank() || str.isEmpty()
    }
    private fun match(password: String, confirmPassword:String) : Boolean{
        return password == confirmPassword
    }
}