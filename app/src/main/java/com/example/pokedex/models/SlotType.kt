package com.example.pokedex.models

import com.google.gson.annotations.SerializedName

data class SlotType(
    @SerializedName("slot") val slot: Int?,
    @SerializedName("type") val type: Type
)
