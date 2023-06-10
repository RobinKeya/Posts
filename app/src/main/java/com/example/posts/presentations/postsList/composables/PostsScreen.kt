package com.example.posts.presentations.postsList.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.posts.presentations.Description
import com.example.posts.presentations.postsList.PostsScreenState

@Composable
fun PostsScreen(postsScreenState: PostsScreenState, onCardClick: (id: Int) -> Unit) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar()}
    ) {

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()){
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

            LazyColumn(contentPadding = PaddingValues(8.dp)){
                items(postsScreenState.posts){
                    PostsItem(post = it, onCardClick = {id-> onCardClick(id)})
                }
            }

        }
    }
}



