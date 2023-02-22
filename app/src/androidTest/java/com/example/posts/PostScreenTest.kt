package com.example.posts

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.posts.presentations.Description
import com.example.posts.presentations.postsList.PostsScreen
import com.example.posts.presentations.postsList.PostsScreenState
import com.example.posts.ui.theme.PostsTheme
import org.junit.Rule
import org.junit.Test

class PostScreenTest {
    @get: Rule
    val testRule : ComposeContentTestRule = createComposeRule()

    @Test
    fun initialState_isRendered(){
        testRule.setContent{
            PostsTheme() {
                PostsScreen(
                    postsScreenState = PostsScreenState(
                        posts = emptyList(),
                        isLoading = true
                    ) )
            }
        }
        testRule.onNodeWithContentDescription(Description.DESCRIPTION_ISLOADING)
            .assertIsDisplayed()
    }

    @Test
    fun stateWithContent_isRendered(){
        val posts = DummyContent.getDummyContent()
        testRule.setContent {
            PostsTheme {
                PostsScreen(postsScreenState = PostsScreenState(
                    posts = posts,
                    isLoading = false
                ))
            }
        }
        testRule.onNodeWithText(posts[0].body).assertIsDisplayed()
        testRule.onNodeWithText(posts[0].title).assertIsDisplayed()
        testRule.onNodeWithContentDescription(Description.DESCRIPTION_ISLOADING).assertDoesNotExist()
    }

    @Test
    fun stateWithError_isRendered(){
        testRule.setContent {
            PostsTheme {
                PostsScreen(postsScreenState = PostsScreenState(
                    posts = emptyList(),
                    isLoading = false,
                    error = "Something went wrong"
                ))
            }
        }
        testRule.onNodeWithText("Something went wrong").assertIsDisplayed()
        testRule.onNodeWithContentDescription(Description.DESCRIPTION_ISLOADING).assertDoesNotExist()

    }

}