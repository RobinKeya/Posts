package com.example.posts.presentations.userDetails.userAlbum

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlbumScreen(albumScreenState: AlbumScreenState,
                onCardClick : (id: Int)-> Unit) {
    Box(modifier = Modifier.fillMaxSize()
        ,contentAlignment = Alignment.Center) {
        LazyColumn(){
            items(albumScreenState.albums){album->
                Card(
                    elevation = 4.dp,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable { onCardClick(album.id) }
                ) {
                    Row(horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(text = album.title,
                            style = MaterialTheme.typography.h2)
                    }
                }
            }
        }
    }
}