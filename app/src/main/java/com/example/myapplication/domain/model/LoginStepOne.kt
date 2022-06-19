package com.example.myapplication.domain.model

import com.example.myapplication.network.reponse.ResponseKeyboard

data class LoginStepOne(
    var intentionId: String? = null,
    var keyboard: ArrayList<ResponseKeyboard> = arrayListOf()
)
