package com.example.myapicall.model


import com.google.gson.annotations.SerializedName

data class  JokeResponse(
    @SerializedName("type")
    val type: String?,
    @SerializedName("joke")
    val jokes: List<Jokes?>?
)