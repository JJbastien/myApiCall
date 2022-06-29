package com.example.myapicall.model


import com.google.gson.annotations.SerializedName

data class Jokes(
    @SerializedName("categories")
    val categories: List<String?>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("joke")
    val joke: String?
)