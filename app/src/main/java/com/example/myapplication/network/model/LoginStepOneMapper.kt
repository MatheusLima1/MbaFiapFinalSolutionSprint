package com.example.myapplication.network.model

import com.example.myapplication.domain.model.LoginStepOne
import com.example.myapplication.domain.utils.DomainMapper
import com.example.myapplication.network.reponse.ResponseLoginStepOne

class LoginStepOneMapper : DomainMapper<LoginStepOne, ResponseLoginStepOne> {
    override fun mapToDomainModel(model: LoginStepOne) = ResponseLoginStepOne(
        intentionId = model.intentionId,
        keyboard = model.keyboard
    )

    override fun mapFromDomainModel(domainModel: ResponseLoginStepOne) = LoginStepOne(
        intentionId = domainModel.intentionId,
        keyboard = domainModel.keyboard!!
    )
}