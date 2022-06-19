package com.example.myapplication.network.reponse

import com.google.gson.annotations.SerializedName

data class ResponseLoginStepOne(
    @SerializedName("intentionId") var intentionId: String? = null,
    @SerializedName("keyboard") var keyboard: ArrayList<ResponseKeyboard> = arrayListOf()
)