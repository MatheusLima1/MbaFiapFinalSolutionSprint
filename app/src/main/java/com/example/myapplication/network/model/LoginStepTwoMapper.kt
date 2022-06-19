package com.example.myapplication.network.model

import com.example.myapplication.domain.model.LoginData
import com.example.myapplication.domain.utils.DomainMapper
import com.example.myapplication.network.reponse.ResponseLoginStepTwo

class LoginStepTwoMapper : DomainMapper<ResponseLoginStepTwo, LoginData> {
    override fun mapToDomainModel(model: ResponseLoginStepTwo) = LoginData(
        expireIn = model.expireIn,
        refreshToken = model.refreshToken,
        accessToken = model.accessToken
    )

    override fun mapFromDomainModel(domainModel: LoginData) = ResponseLoginStepTwo(
        expireIn = domainModel.expireIn,
        refreshToken = domainModel.refreshToken,
        accessToken = domainModel.accessToken
    )
}