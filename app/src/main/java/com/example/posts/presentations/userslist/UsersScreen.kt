package com.example.posts.presentations.userslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.posts.data.remote.User
import com.example.posts.presentations.Description

@Composable
fun UserSreen(usersScreenState: UsersScreenState, onCardClick: (id: Int) -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 100.dp),
        contentAlignment = Alignment.Center) {
        LazyColumn(contentPadding = PaddingValues(4.dp)){
            items(usersScreenState.users){user->
                UserDetails(user, onCardClick = {id->onCardClick(id)})
            }
        }
        if(usersScreenState.isLoading){
            CircularProgressIndicator(
                Modifier.semantics {
                    this.contentDescription = Description.DESCRIPTION_ISLOADING
                }
            )
        }
        if (usersScreenState.error != null){
            Text(text = usersScreenState.error)
            //TODO
            //add logic to retry, restore state
        }
    }
}

@Composable
fun UserDetails(user: User, onCardClick : (id:Int)-> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(4.dp)
            .clickable { onCardClick(user.id) }) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            //use stringResource
            Text(text = "User ${user.id}",
            style = MaterialTheme.typography.h2)
            Text(text = user.name,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(top = 4.dp))
        }
    }

}