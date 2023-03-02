package com.example.posts.presentations.userDetails.userTodo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.posts.data.remote.Todo

@Composable
fun UserTodoScreen(todoScreenState: TodoScreenState) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
            val todos = todoScreenState.todos
        LazyColumn(contentPadding = PaddingValues(4.dp)){
            items(todos){todo->
                TodoItem(todo = todo)
            }
        }
    }
}

@Composable
fun TodoItem(todo: Todo) {
    Card(elevation = 4.dp,
        modifier = Modifier.padding(8.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(6.dp)) {
            Text(text = todo.title,
            style = MaterialTheme.typography.h2)
            Checkbox(checked = todo.completed, onCheckedChange ={} )
        }
    }
}