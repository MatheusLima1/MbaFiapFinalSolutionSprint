package com.example.myapplication.domain.model

data class LoginStepOneRequest(
    var intentionId: String? = null,
    var password: ArrayList<String> = arrayListOf()
)
