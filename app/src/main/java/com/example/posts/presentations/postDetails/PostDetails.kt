package com.example.posts.presentations.postDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PostDetails(vm: PostDetailsViewModel) {

    val state = vm.state.value

    if (state != null){
        Box(contentAlignment = Alignment.Center,
            modifier =  Modifier.fillMaxSize()) {
            Card(elevation = 4.dp,
                modifier = Modifier.fillMaxSize(0.8f)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(text = state.userId.toString())

                    Text(text =state.title )

                    Text(text = state.body)
                }


            }
        }
    }

}