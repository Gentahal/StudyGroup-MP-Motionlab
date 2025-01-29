package com.example.jcmotion.data

import com.google.gson.annotations.SerializedName

data class CatFactResponse(
    @SerializedName("fact") val fact: String
)