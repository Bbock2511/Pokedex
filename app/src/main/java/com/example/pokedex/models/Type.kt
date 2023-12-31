package com.example.pokedex.models

import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null
)
