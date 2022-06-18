package com.example.myapplication.domain.model

import com.google.gson.annotations.SerializedName

data class Keyboard(
    @SerializedName("id") var id: String? = null,
    @SerializedName("values") var values: String? = null
)