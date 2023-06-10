package com.example.posts.presentations.postDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.posts.R
import com.example.posts.presentations.postDetails.composables.TopAppBar

@Composable
fun PostDetailsScreen(vm: PostDetailsViewModel) {

    val state = vm.state.value

    if (state != null){
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar()
            }
        ) {
            Box(contentAlignment = Alignment.Center,
                modifier =  Modifier.fillMaxSize()) {
                    LazyColumn(
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        item(){
                            Text(text = stringResource(id = R.string.post_by ,state.userId ) )
                        }
                        item(){
                            Text(text =state.title,
                                style = MaterialTheme.typography.h2,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis)
                        }
                        item(){
                            Text(text = state.body,
                                style = MaterialTheme.typography.h2,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis)
                        }


                    }



            }
        }
    }
}