package com.example.posts.data.di

import com.example.posts.data.remote.PostsInterface
import com.example.posts.utils.Constants
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object PostsModule {
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .baseUrl(Constants.BASE_URL)
            .build()
    }
    fun providePostInterfaceApi(retrofit: Retrofit): PostsInterface{
        return retrofit.create(PostsInterface::class.java)
    }
}