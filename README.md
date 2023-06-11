# Posts App

## Description

PostsApp is an android application that consumes [json placeholder api](https://jsonplaceholder.typicode.com/) to get Posts, Comments associated to posts, User's list, albums,photos and Todos.

MVVM presentation pattern has been used in the development of the application. 

Jetpack libraries such as Jetpack Compose for UI developemnt and Hilt for dependency Injection has also been used to develop the application.

Build system: Gradle.

Min API level 24.

## Note

The application is a work in progress and therefore bugs and unimplemented features might be experienced while the app is in use.

Contributions and bug reports are welcome. 

## Features of the app

(*Checked feature indicates that the feature has been implemented while unchecked feature indicates the feature has not yet been worked on.*)

- [x] Posts Screen --> Screen showing a list of posts from all users.

- [x] Post Details screen --> Screen showing details of individual posts.

- [x] Users screen --> Screen showing list of all users 

- [x] User Details screen -> Screen showing user information,  access to User's posts, albums, todos and photos. 

- [ ] User's todos --> Screen displaying a user's todo list. 

- [ ] User's albums --> Screen displaying user's albums

- [ ] User's Photos --> Screen displaying user's photos.

- [ ] Post's comments --> Show comments to a particular posts. 

- [ ] Add posts --> Make it possible to add posts to the list of posts. 

- [ ] Delete post --> Ability to delete a post.

- [ ] Update posts --> Ability to edit post's information. 

- [ ] Authentication --> Sign up and Login of app's users. 

- [ ] Profile screen --> Profile screen for an authenticated user. 

- [ ] Settings Screen --> Ability for a user to do preferred customizations. 

### Technologies Used

[Retrofit](https://square.github.io/retrofit/)  Type-safe HTTP client for android and Java.

[Jetpack Compose](https://developer.android.com/jetpack/compose): A modern UI toolkit for building native Android apps

[Jetpack Navigation](https://developer.android.com/guide/navigation): A library for building navigation on Android

[Hilt](https://developer.android.com/training/dependency-injection/hilt-android): A dependency injection library for Android

[Json placeholderApi](https://jsonplaceholder.typicode.com/): API that provides Posts, Users,Comments, Todos, Albums and Photos.

[Kotlin Coroutines](https://kotlinlang.org/docs/multiplatform-mobile-concurrency-and-coroutines.html#coroutines): A library for asynchronous programming in Kotlin

## Permission

The application requires an active internet connection to retrieve information from the API.

## Screenshots

![alt text](https://github.com/RobinKeya/Posts/blob/master/Screenshots/Home...PNG "Home screen")
![alt text](https://github.com/RobinKeya/Posts/blob/master/Screenshots/users.PNG "Users screen")
![alt text](https://github.com/RobinKeya/Posts/blob/master/Screenshots/user_detail.PNG "User screen")



