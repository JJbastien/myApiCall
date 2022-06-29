package com.example.myapicall.rest

import com.example.myapicall.model.JokeResponse
import com.example.myapicall.model.Jokes

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JokeServiceApi {
//Test route
  //  @GET(RANDOM_JOKE)

 // suspend fun getRandomJoke( : Response<Jokes>


    //function to get random list of jokes by batches of 20
    @GET(RANDOM_LIST_PATH)
    suspend fun getRandomList(
        @Path("number") number: Int ,
        @Query("exclude", encoded = true) excludedCategories: String
    ): Response<JokeResponse>

//   Function to get random jokes excluding explicit content
   suspend fun getRandomJoke(
        @Query("exclude", encoded = true) excludedCategories: String
   ): Response<Jokes>


    //route to change name of characters in the joke
    @GET()
    suspend fun getCustom(
        @Query("firstName") firstName: String,
        @Query("lastName") lastName: String
    ): Response<Jokes>


        companion object {
            const val BASE_URL = "http://api.icndb.com/jokes/"
            private const val  RANDOM_JOKE = "random"
            //check value
        private const val RANDOM_LIST_PATH = "20"
        //private const val JOKES_LOAD_SIZE = 15


        }
}