package com.example.myapplication.network

import com.example.myapplication.network.reponse.RequestLoginStepOne
import com.example.myapplication.network.reponse.ResponseLoginStepOne
import com.example.myapplication.network.reponse.ResponseLoginStepTwo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("intention/{User}")
    suspend fun getOauthIntention(@Path("User") cpfCnpj: Long): ResponseLoginStepOne

    @POST("Login")
    suspend fun login(@Body requestTwo: RequestLoginStepOne): ResponseLoginStepTwo
}