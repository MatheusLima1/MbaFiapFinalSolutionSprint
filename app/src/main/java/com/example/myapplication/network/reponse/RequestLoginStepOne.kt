package com.example.myapplication.network.reponse

import com.google.gson.annotations.SerializedName

data class RequestLoginStepOne(
    @SerializedName("intentionId") var intentionId: String? = null,
    @SerializedName("password") var password: ArrayList<String> = arrayListOf()
)