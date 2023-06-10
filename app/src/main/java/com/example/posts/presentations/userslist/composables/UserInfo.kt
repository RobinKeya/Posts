package com.example.posts.presentations.userslist.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.posts.data.remote.User

@Composable
fun UserInfo(user: User, onCardClick: (id: Int)->Unit) {
    Card(elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onCardClick(user.id) }) {
        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            ,horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = user.name,
                style = MaterialTheme.typography.h2)

            Text(text = "User ${user.id}",
                style = MaterialTheme.typography.body1)
        }
    }
}