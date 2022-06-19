package com.example.myapplication.network.model

import com.example.myapplication.domain.model.LoginStepOneRequest
import com.example.myapplication.domain.utils.DomainMapper
import com.example.myapplication.network.reponse.RequestLoginStepOne

class LoginStepOneRequestMapper: DomainMapper<RequestLoginStepOne, LoginStepOneRequest> {
    override fun mapToDomainModel(model: RequestLoginStepOne)= LoginStepOneRequest (
        intentionId = model.intentionId,
        password = model.password
    )

    override fun mapFromDomainModel(domainModel: LoginStepOneRequest) = RequestLoginStepOne (
        intentionId = domainModel.intentionId,
        password = domainModel.password
    )
}