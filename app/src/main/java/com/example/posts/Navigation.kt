package com.example.posts

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.posts.presentations.BottomMenuItem
import com.example.posts.presentations.ProfileScreen
import com.example.posts.presentations.SettingScreen
import com.example.posts.presentations.postDetails.PostDetails
import com.example.posts.presentations.postDetails.PostDetailsViewModel
import com.example.posts.presentations.postsList.PostsScreen
import com.example.posts.presentations.postsList.PostsViewModel
import com.example.posts.presentations.userslist.UserSreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination ="home" ){
        composable(route = "home"){
            val vm : PostsViewModel = viewModel()
            PostsScreen(postsScreenState = vm.state.value)
        }
        composable(route = "home/{post_id}",
        arguments = listOf(navArgument("post_id"){
            type = NavType.IntType
        })
        ){
            val vm : PostDetailsViewModel= viewModel()
            PostDetails(vm)
        }

        composable(route = "users"){
            UserSreen()
        }
        composable(route= "profile"){
            ProfileScreen()
        }

        composable(route= "settings"){
            SettingScreen()
        }
    }

}

@Composable
fun BottomNavBar(
    items : List<BottomMenuItem>,
    navController : NavController,
    modifier: Modifier = Modifier,
    onItemClick : (BottomMenuItem)-> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier= modifier,
        backgroundColor = Color.White,
        elevation = 4.dp
    ) {
        items.forEach { item->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected =selected,
                onClick = { onItemClick(item) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription =item.name )
                        if(selected){
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}