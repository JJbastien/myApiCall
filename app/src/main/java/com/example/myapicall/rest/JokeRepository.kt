package com.example.myapicall.rest

import com.example.myapicall.model.JokeResponse
import com.example.myapicall.model.Jokes

import retrofit2.Response
import javax.inject.Inject


interface JokeRepository {

suspend  fun getRandom(): Response<Jokes>
 suspend fun  getNonEndinglist(): Response<JokeResponse>
 suspend fun getCustomJoke(): Response<Jokes>
}

class JokeRepositoryImpl @Inject constructor (
    private val serviceApi: JokeServiceApi
): JokeRepository {

    override suspend fun getRandom(): Response<Jokes> =
       serviceApi.getRandomJoke("explicit")

    override suspend fun getNonEndinglist(): Response<JokeResponse> =
       serviceApi.getRandomList(20, "explicit")

    override suspend fun getCustomJoke(): Response<Jokes> =
       serviceApi.getCustom("firstName", "lastName")


}
