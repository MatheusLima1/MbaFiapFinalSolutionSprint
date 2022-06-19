package com.example.myapplication.repository

import com.example.myapplication.domain.model.LoginData
import com.example.myapplication.domain.model.LoginStepOne
import com.example.myapplication.network.ApiService
import com.example.myapplication.network.model.LoginStepOneMapper
import com.example.myapplication.network.model.LoginStepTwoMapper
import com.example.myapplication.network.reponse.RequestLoginStepOne

class GeneralRepository(
    private val service: ApiService,
    private val stepOneMapper: LoginStepOneMapper,
    private val stepTwoMapper: LoginStepTwoMapper
) : IGeneralRepository {
    override suspend fun getOauthIntention(cpfCnpj: Long): LoginStepOne {
        val result = service.getOauthIntention(cpfCnpj)
        return stepOneMapper.mapFromDomainModel(result)
    }

    override suspend fun login(requestTwo: RequestLoginStepOne): LoginData {
        val result = service.login(requestTwo)
        return stepTwoMapper.mapToDomainModel(result)
    }
}