package com.example.posts.presentations.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SignupScreen(modifier: Modifier= Modifier,
signUpViewModel: SignUpViewModel) {
    var value by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = signUpViewModel.userName.value,
            onValueChange = { newText ->
                signUpViewModel.userName.value= newText
            },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Type your name") }
        )
    }
    
}