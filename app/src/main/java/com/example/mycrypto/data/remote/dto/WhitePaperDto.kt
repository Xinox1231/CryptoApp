package com.example.mycrypto.data.remote.dto

import com.google.gson.annotations.SerializedName

data class WhitePaperDto(
    @SerializedName("link") val link: String,
    @SerializedName("thumbnail") val thumbnail: String
)