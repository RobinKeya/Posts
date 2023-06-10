package com.example.posts.presentations.userDetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.posts.DummyContent

@Composable
fun UserDetails(
    viewModel: UserDetailsViewModel,
    onCardClick : (index: Int)-> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val list = DummyContent.getUserContent()
    val user = viewModel.state.value

    if (user != null){
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(user.name)
            }
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)) {

                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    columns = GridCells.Fixed(2),
                    content ={
                        items(list.size){ index->
                            Card(
                                elevation = 4.dp,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50))
                                    .padding(8.dp)
                                    .clickable { onCardClick(index) }
                                    .fillMaxWidth()
                                    .height(150.dp)
                            ) {
                                Column(verticalArrangement = Arrangement.Center
                                    ,horizontalAlignment = Alignment.CenterHorizontally) {
                                    Icon(painter = painterResource(id = list[index].icon)
                                        , contentDescription = list[index].title,
                                        modifier = Modifier.size(24.dp))

                                    Text(text = list[index].title)
                                }
                            }
                        }
                    } )

            }
        }
    }

}

@Composable
fun TopAppBar(name: String) {
    Row(horizontalArrangement = Arrangement.Center,
    modifier =  Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
        Text(text = name,
            style = MaterialTheme.typography.h2)
    }
}