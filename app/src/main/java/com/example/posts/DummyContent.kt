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
    //todo
    //update the drawable to reflect title
    fun getUserDetails(): List<UserDetailsContent>{
        return listOf(
            UserDetailsContent("Information",R.drawable.ic_baseline_home_24),
            UserDetailsContent("Posts",R.drawable.ic_baseline_home_24),
            UserDetailsContent("Todos",R.drawable.ic_baseline_home_24),
            UserDetailsContent("Albums",R.drawable.ic_baseline_home_24)
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