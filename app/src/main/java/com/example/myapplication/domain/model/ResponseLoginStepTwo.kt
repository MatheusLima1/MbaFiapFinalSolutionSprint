package com.example.myapplication.domain.model

import com.google.gson.annotations.SerializedName

data class ResponseLoginStepTwo(
    @SerializedName("expireIn") var expireIn: String? = null,
    @SerializedName("accessToken") var accessToken: String? = null,
    @SerializedName("refreshToken") var refreshToken: String? = null
)