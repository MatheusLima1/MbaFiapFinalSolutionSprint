package com.example.myapplication.presentation.ui.password

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPasswordBinding

class PasswordFragment : Fragment() {

    companion object {
        fun newInstance() = PasswordFragment()
    }

    private lateinit var viewModel: PasswordViewModel
    private lateinit var binding: FragmentPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPasswordBinding.bind(
            inflater.inflate(
                R.layout.fragment_password,
                container,
                false
            )
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PasswordViewModel::class.java)

        viewModel.shuffleList()

        val layoutCircleList = binding.layoutCircleList

        var randomNumOne = getNumberFromShuffledList(0)
        var randomNumTwo = getNumberFromShuffledList(1)
        var randomNumThree = getNumberFromShuffledList(2)
        var randomNumFour = getNumberFromShuffledList(3)
        var randomNumFive = getNumberFromShuffledList(4)
        var randomNumSix = getNumberFromShuffledList(5)
        var randomNumSeven = getNumberFromShuffledList(6)
        var randomNumEight = getNumberFromShuffledList(7)
        var randomNumNine = getNumberFromShuffledList(8)

        layoutCircleList.circleOne.txtNumber.text = viewModel.valueOfButton(
            layoutCircleList.circleOne.txtNumber.text.toString(),
            randomNumOne,
            randomNumTwo
        )
        layoutCircleList.circleTwo.txtNumber.text = viewModel.valueOfButton(
            layoutCircleList.circleTwo.txtNumber.text.toString(),
            randomNumThree,
            randomNumFour
        )
        layoutCircleList.circleThree.txtNumber.text = viewModel.valueOfButton(
            layoutCircleList.circleThree.txtNumber.text.toString(),
            randomNumFive,
            randomNumSix
        )
        layoutCircleList.circleFour.txtNumber.text = viewModel.valueOfButton(
            layoutCircleList.circleFour.txtNumber.text.toString(),
            randomNumSeven,
            randomNumEight
        )
        layoutCircleList.circleFive.txtNumber.text = viewModel.valueOfButton(
            layoutCircleList.circleFive.txtNumber.text.toString(),
            randomNumNine,
            randomNumTwo
        )
    }

    private fun getNumberFromShuffledList(position: Int) = viewModel.getNumber(position)

    override fun onResume() {
        super.onResume()
        Math.random()
    }
}