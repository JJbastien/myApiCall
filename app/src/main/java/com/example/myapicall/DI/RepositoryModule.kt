package com.example.myapicall.DI

import android.content.Context
import com.example.myapicall.rest.JokeRepository
import com.example.myapicall.rest.JokeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
 abstract class RepositoryModule{
     @Binds
     abstract fun providesNetworkRepository(
         jokeRepositoryImpl: JokeRepositoryImpl): JokeRepository
 }




