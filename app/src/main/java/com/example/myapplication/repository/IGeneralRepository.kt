package com.example.myapplication.repository

import com.example.myapplication.domain.model.LoginData
import com.example.myapplication.domain.model.LoginStepOne
import com.example.myapplication.network.reponse.RequestLoginStepOne

interface IGeneralRepository {
    suspend fun getOauthIntention(cpfCnpj: Long): LoginStepOne
    suspend fun login(requestTwo: RequestLoginStepOne): LoginData
}