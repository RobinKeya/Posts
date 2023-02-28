package com.example.posts.presentations.postsList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.posts.data.remote.Post
import com.example.posts.presentations.Description

@Composable
fun PostsScreen(postsScreenState: PostsScreenState, onCardClick: (id: Int) -> Unit) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()){
        LazyColumn(contentPadding = PaddingValues(8.dp)){
            items(postsScreenState.posts){
                PostsItem(post = it, onCardClick = {id-> onCardClick(id)})
            }
        }
        if(postsScreenState.isLoading){
            CircularProgressIndicator(
                Modifier.semantics {
                    this.contentDescription = Description.DESCRIPTION_ISLOADING
                }
            )
        }
        if (postsScreenState.error != null){
            Text(text = postsScreenState.error)
        }
    }
}

@Composable
fun PostsItem(post:Post, onCardClick: (id: Int)-> Unit) {
    Card(elevation = 4.dp,
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onCardClick(post.id) }) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = post.title)
                Text(text = post.body)
            }
            Text(text = post.userId.toString())
        }
        
    }
}