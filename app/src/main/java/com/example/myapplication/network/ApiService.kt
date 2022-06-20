package com.example.myapplication.network

import com.example.myapplication.network.reponse.RequestLoginStepOne
import com.example.myapplication.network.reponse.ResponseLoginStepOne
import com.example.myapplication.network.reponse.ResponseLoginStepTwo
import retrofit2.http.*

interface ApiService {
    @GET("intention")
    suspend fun getOauthIntention(@Query("User") cpfCnpj: Long): ResponseLoginStepOne

    @POST("Login")
    suspend fun login(@Body requestTwo: RequestLoginStepOne): ResponseLoginStepTwo
}