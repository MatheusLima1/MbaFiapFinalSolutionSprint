package com.example.myapplication.network.model

import com.example.myapplication.domain.model.Keyboard
import com.example.myapplication.domain.utils.DomainMapper
import com.example.myapplication.network.reponse.ResponseKeyboard


class KeyboardMapper : DomainMapper<ResponseKeyboard, Keyboard> {
    override fun mapToDomainModel(model: ResponseKeyboard) =  Keyboard (
        id = model.id,
        values = model.values
    )

    override fun mapFromDomainModel(domainModel: Keyboard) = ResponseKeyboard (
        id = domainModel.id,
        values = domainModel.values
    )
}