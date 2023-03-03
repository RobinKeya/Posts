package com.example.posts.presentations.userDetails

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserInfoScreen(userDetailsViewModel: UserDetailsViewModel) {
    val user = userDetailsViewModel.state.value
    var expanded by remember{ mutableStateOf(false) }
    var companyExpanded by remember{ mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )

    if (user != null){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Card(elevation = 4.dp, 
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.8f)) {
                Column(){
                    Text(text ="Name : ${user.name}",
                        style = MaterialTheme.typography.h2)
                    Text(text ="Email : ${user.email}",
                        style = MaterialTheme.typography.h2)
                    Text(text ="Phone : ${user.phone}",
                        style = MaterialTheme.typography.h2)
                    Text(text ="Username : ${user.username}",
                        style = MaterialTheme.typography.h2)
                    Text(text ="Website : ${user.website}",
                        style = MaterialTheme.typography.h2)
                    
                }
            }
            
            OutlinedButton(onClick = { expanded = !expanded }) {
                Text(text = "Address")
                if (expanded){
                    Column() {
                        Text(text = "City : ${user.address.city}")
                        Text(text = "Street : ${user.address.street}")
                        Text(text = "Suite : ${user.address.suite}")
                        Text(text = "ZIP Code : ${user.address.zipcode}")
                    }
                }
            }

            OutlinedButton(onClick = { companyExpanded = !companyExpanded }) {
                Text(text = "Company")

                if (companyExpanded){
                    Column() {
                        Text(text = "Name : ${user.company.name}")
                        Text(text = "BS : ${user.company.bs}")
                        Text(text = "Catch Phrase : ${user.company.catchPhrase}")
                    }
                }
            }

        }

    }
}
