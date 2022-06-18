package com.example.myapplication.presentation.ui.password

import androidx.lifecycle.ViewModel

class PasswordViewModel : ViewModel() {

    private val listNumber: List<Int> = listOf<Int>(0,1,2,3,4,5,6,7,8,9)
    private  var shuffledList: List<Int> = listOf()

    fun shuffleList(): List<Int>{
        shuffledList = listNumber.shuffled()
        return shuffledList
    }

    fun getNumber(position: Int): Int{
        return shuffledList[position]
    }

    fun valueOfButton(textButton: String, valueOne:Int, valueTwo:Int): String {
        return textButton.replace(CIPHER_ONE, valueOne.toString()).replace(CIPHER_TWO, valueTwo.toString())
    }

    private companion object{
        const val CIPHER_ONE = "%1"
        const val CIPHER_TWO = "%2"
    }
}