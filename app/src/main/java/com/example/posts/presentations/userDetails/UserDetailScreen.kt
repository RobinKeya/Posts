package com.example.posts.presentations.userDetails

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.posts.DummyContent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UserDetailsScreen(
    viewModel: UserDetailsViewModel,
    onItemClick: (id: Int)->Unit
) {
    Box(
        contentAlignment = Alignment.Center, 
        modifier = Modifier.fillMaxSize()) {

        val list = DummyContent.getUserDetails()

        Text(text = "User ${viewModel.state.value?.id}")

        LazyVerticalGrid(cells = GridCells.Fixed(2)
            , content ={
                items(list.size){ index->
                    Card(
                        elevation = 4.dp,
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .size(60.dp)
                            .clickable { onItemClick(index) }
                    ) {
                        Column() {
                            Icon(painter = painterResource(id = list[index].icon)
                                , contentDescription = list[index].title,
                            modifier = Modifier.size(24.dp))

                            Text(text = list[index].title)
                        }
                    }
                }
            },
            contentPadding = PaddingValues(start = 8.dp)
        )
    }
}