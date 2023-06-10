package com.example.posts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import com.example.posts.data.remote.Post
import com.example.posts.presentations.BottomMenuItem
import com.example.posts.presentations.userDetails.UserDetailsContent

object DummyContent {
    fun  getDummyContent(): List<Post>{
        return  listOf(
            Post("Body one",1,"title one",1),
            Post("Body two",1,"title two",2),
            Post("Body three",1,"title three",3),
            Post("Body four",1,"title four",4),
            Post("Body five",1,"title five",5),
            Post("Body six",1,"title six",6),
            Post("Body seven",1,"title seven",7),
        )
    }
    //Todo
    //change the drawables to correspond to titles.
    fun getUserContent(): List<UserDetailsContent>{
        return  listOf(
            UserDetailsContent(0, "Information", R.drawable.baseline_info_24),
            UserDetailsContent(1, "Posts", R.drawable.baseline_feed_24),
            UserDetailsContent(2, "Todos", R.drawable.baseline_task_24),
            UserDetailsContent(3, "Albums", R.drawable.baseline_photo_album_24)
        )
    }
    fun getBottomNavContent(): List<BottomMenuItem>{
        return listOf(
            BottomMenuItem(name= "Home", Icons.Default.Home,"home"),
            BottomMenuItem(name= "Users", Icons.Default.List,"users"),
            BottomMenuItem(name= "Profile", Icons.Default.Person,"profile"),
            BottomMenuItem(name= "Settings", Icons.Default.Settings,"settings")
        )
    }
}