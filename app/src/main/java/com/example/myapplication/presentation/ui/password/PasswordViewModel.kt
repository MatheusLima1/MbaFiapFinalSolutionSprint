package com.example.myapplication.presentation.ui.password

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.model.LoginData
import com.example.myapplication.domain.model.LoginStepOne
import com.example.myapplication.network.reponse.RequestLoginStepOne
import com.example.myapplication.repository.GeneralRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordViewModel
@Inject constructor(
    private val repository: GeneralRepository
) : ViewModel() {

    var stepOne: LoginStepOne? = null
    var stepTwo: LoginData? = null

    fun getLoginStepOneData(cpfCnpj: String, success: (LoginStepOne) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            stepOne = repository.getOauthIntention(cpfCnpj.toLong())
            stepOne?.let {
                success(it)
            }
        }
    }

    fun sendLoginInformation(
        requestStepOne: RequestLoginStepOne,
        success: (LoginData) -> Unit,
        failure: () -> Unit = {}
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                stepTwo = repository.login(requestStepOne)
                stepTwo?.let {
                    success(it)
                }
            } catch (ex: Exception){
              failure()
            }
        }
    }

    fun valueOfButton(textButton: String, valueOne: String, valueTwo: String): String {
        return textButton.replace(CIPHER_ONE, valueOne)
            .replace(CIPHER_TWO, valueTwo)
    }

    private companion object {
        const val CIPHER_ONE = "%1"
        const val CIPHER_TWO = "%2"
    }
}