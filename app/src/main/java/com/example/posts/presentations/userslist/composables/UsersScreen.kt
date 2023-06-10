package com.example.posts.presentations.userslist.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.posts.presentations.userslist.UsersScreenState

@Composable
fun UserScreen(
    usersScreenState: UsersScreenState,
    onCardClick: (id:Int)->Unit) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar() }
    ) {
        Box(modifier = Modifier.fillMaxSize()
            ,contentAlignment = Alignment.Center) {
            LazyColumn(contentPadding = PaddingValues(4.dp)){
                items(usersScreenState.users){user->
                    UserInfo(user = user, onCardClick ={id-> onCardClick(id)} )
                }
            }
        }
    }
}

