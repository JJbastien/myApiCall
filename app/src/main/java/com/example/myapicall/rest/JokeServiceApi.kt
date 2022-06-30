package com.example.myapicall.rest

import com.example.myapicall.model.JokeResponse
import com.example.myapicall.model.Jokes

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JokeServiceApi {


    //  Function to get random jokes excluding explicit content
    @GET(RANDOM)
   suspend fun getRandomJoke(
        @Query("exclude", encoded = true) excludedCategories: String
   ): Response<Jokes>


   // Get random list of jokes by batches of 20
   @GET(RANDOM_LIST_PATH)
    suspend fun getRandomList(
       @Path("limit") limit: Int = 20,
       @Query("exclude", encoded = true) excludedCategories: String
    ): Response<JokeResponse>

    //route to change name of characters in the joke
    @GET(RANDOM)
    suspend fun getCustom(
        @Query("firstName") firstName: String ,
        @Query("lastName") lastName: String
        ): Response<Jokes>


    companion object {
        const val BASE_URL = "http://api.icndb.com/jokes/"
        private const val  RANDOM = "random"
        private const val RANDOM_LIST_PATH = "random/{limit}"
    }
}