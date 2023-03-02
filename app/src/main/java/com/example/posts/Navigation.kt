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
import com.example.posts.presentations.userDetails.UserDetails
import com.example.posts.presentations.userDetails.UserDetailsViewModel
import com.example.posts.presentations.userDetails.userTodo.UserTodoScreen
import com.example.posts.presentations.userslist.UserSreen
import com.example.posts.presentations.userslist.UsersScreenState
import com.example.posts.presentations.userslist.UsersViewModel


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination ="home" ){
        composable(route = "home"){
            val vm : PostsViewModel = viewModel()
            PostsScreen(postsScreenState = vm.state.value){id->
                navController.navigate("home/${id}")
            }
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
            val vm: UsersViewModel = viewModel()
            UserSreen(usersScreenState = vm.state.value){ id ->
                navController.navigate("users/${id}")
            }
        }
        composable(route= "users/{user_id}",
        arguments = listOf(navArgument("user_id"){
            type = NavType.IntType
        })
        ){
            val vm : UserDetailsViewModel = viewModel()
            UserDetails(viewModel = vm){index->
                when(index){
                    0-> navController.navigate("information")
                    1-> navController.navigate("posts")
                    2->navController.navigate("albums")
                    3-> navController.navigate("todos")
                }
            }
        }

        composable(route = "information"){

        }
        composable(route = "posts"){

        }
        composable(route = "albums"){

        }
        composable(route = "todos"){
            val vm: UserDetailsViewModel = viewModel()
            UserTodoScreen(todoScreenState =vm.todoState.value )
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