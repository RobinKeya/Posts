package com.example.posts.presentations.userslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.posts.DummyContent
import com.example.posts.data.remote.User

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UserSreen(usersScreenState: UsersScreenState, onCardClick: (id:Int)->Unit) {
    Box(modifier = Modifier.fillMaxSize()
        ,contentAlignment = Alignment.Center) {

        LazyColumn(contentPadding = PaddingValues(4.dp)){
            items(usersScreenState.users){user->
                UserInfo(user = user, onCardClick ={id-> onCardClick(id)} )
            }
        }
    }
}

@Composable
fun UserInfo(user: User, onCardClick: (id: Int)->Unit) {
    Card(elevation = 4.dp,
        modifier = Modifier
            .padding(4.dp)
            .clickable { onCardClick(user.id) }) {
        Row(modifier = Modifier.padding(4.dp)
            ,horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = user.name,
            style = MaterialTheme.typography.h2)

            Text(text = "User ${user.id}",
            style = MaterialTheme.typography.body1)
        }
    }
}