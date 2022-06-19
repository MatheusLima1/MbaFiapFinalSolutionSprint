package com.example.myapplication.domain.model

data class LoginData(
    var expireIn: String? = null,
    var accessToken: String? = null,
    var refreshToken: String? = null
)