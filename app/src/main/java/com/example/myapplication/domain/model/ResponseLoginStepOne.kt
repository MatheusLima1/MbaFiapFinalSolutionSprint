package com.example.myapplication.domain.model

import com.google.gson.annotations.SerializedName

data class ResponseLoginStepOne(
    @SerializedName("intentionId") var intentionId: String? = null,
    @SerializedName("keyboard") var keyboard: ArrayList<Keyboard> = arrayListOf()
)