package com.example.myapplication.network.reponse

import com.google.gson.annotations.SerializedName

data class ResponseKeyboard(
    @SerializedName("id") var id: String? = null,
    @SerializedName("values") var values: List<Long>? = null
)