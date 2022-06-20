package com.example.myapplication.presentation.ui.password

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.CircleLayoutListBinding
import com.example.myapplication.databinding.FragmentPasswordBinding
import com.example.myapplication.domain.model.LoginStepOne
import com.example.myapplication.network.reponse.RequestLoginStepOne
import com.example.myapplication.network.reponse.ResponseKeyboard
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PasswordFragment : Fragment() {

    private val viewModel: PasswordViewModel by viewModels()
    private lateinit var binding: FragmentPasswordBinding
    private var layoutCircleList: CircleLayoutListBinding? = null
    private var boxClickCount: Int = 0
    private var intentionId: String? = null
    private var keyboardOneValue: ResponseKeyboard? = null
    private var keyboardTwoValue: ResponseKeyboard? = null
    private var keyboardThreeValue: ResponseKeyboard? = null
    private var keyboardFourValue: ResponseKeyboard? = null
    private var keyboardFiveValue: ResponseKeyboard? = null

    private var passwords: MutableList<String> = mutableListOf()

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

        val cpfCnpj: String = arguments?.getString(CPF_CNPJ).toString()
        viewModel.getLoginStepOneData(cpfCnpj) {
            activity?.runOnUiThread {
                intentionId = it.intentionId
                fillButtonInfo(it)
                setupListener()
                binding.bntNext.setOnClickListener {
                    doLogin()
                }
            }
        }
    }

    private fun doLogin() {
        viewModel.sendLoginInformation(
            RequestLoginStepOne(
                intentionId,
                passwords as ArrayList<String>
            ),
            success = {
                val dialog = AlertDialog.Builder(requireContext())
                    .setTitle("Login bem Sucedido!")
                    .setMessage("AccessToken: " + it.accessToken + " " + "RefreshToken: " + it.refreshToken + " " + "ExpireIn: " + it.expireIn)
                    .show()
                dialog.show();
                Log.i(
                    "TERMINEI",
                    it.accessToken + " " + it.refreshToken + " " + it.expireIn
                )
            },
            failure = {
                Snackbar.make(
                    binding.root,
                    "Ocorreu um erro ao fazer o login",
                    Snackbar.LENGTH_LONG
                ).show()
            })
    }

    private fun setupListener() {
        layoutCircleList?.let {
            it.circleOne.root.setOnClickListener {
                boxClick()
                keyboardOneValue?.id?.let { it1 ->
                    if (passwords.size < 6)
                        passwords.add(it1)
                }
            }
            it.circleTwo.root.setOnClickListener {
                boxClick()
                if (passwords.size < 6)
                    keyboardTwoValue?.id?.let { it1 -> passwords.add(it1) }
            }
            it.circleThree.root.setOnClickListener {
                boxClick()
                if (passwords.size < 6)
                    keyboardThreeValue?.id?.let { it1 -> passwords.add(it1) }
            }
            it.circleFour.root.setOnClickListener {
                boxClick()
                if (passwords.size < 6)
                    keyboardFourValue?.id?.let { it1 -> passwords.add(it1) }
            }
            it.circleFive.root.setOnClickListener {
                boxClick()
                if (passwords.size < 6)
                    keyboardFiveValue?.id?.let { it1 -> passwords.add(it1) }
            }
            it.backspace.setOnClickListener {
                boxClickDelete()
            }
        }
    }

    private fun fillButtonInfo(loginStepOne: LoginStepOne) {
        layoutCircleList = binding.layoutCircleList
        keyboardOneValue = loginStepOne.keyboard[0]
        keyboardTwoValue = loginStepOne.keyboard[1]
        keyboardThreeValue = loginStepOne.keyboard[2]
        keyboardFourValue = loginStepOne.keyboard[3]
        keyboardFiveValue = loginStepOne.keyboard[4]

        layoutCircleList?.let {
            it.circleOne.txtNumber.text = viewModel.valueOfButton(
                it.circleOne.txtNumber.text.toString(),
                keyboardOneValue?.values?.get(0).toString(),
                keyboardOneValue?.values?.get(1).toString()
            )
            it.circleTwo.txtNumber.text = viewModel.valueOfButton(
                it.circleTwo.txtNumber.text.toString(),
                keyboardTwoValue?.values?.get(0).toString(),
                keyboardTwoValue?.values?.get(1).toString()
            )
            it.circleThree.txtNumber.text = viewModel.valueOfButton(
                it.circleThree.txtNumber.text.toString(),
                keyboardThreeValue?.values?.get(0).toString(),
                keyboardThreeValue?.values?.get(1).toString()
            )
            it.circleFour.txtNumber.text = viewModel.valueOfButton(
                it.circleFour.txtNumber.text.toString(),
                keyboardFourValue?.values?.get(0).toString(),
                keyboardFourValue?.values?.get(1).toString()
            )
            it.circleFive.txtNumber.text = viewModel.valueOfButton(
                it.circleFive.txtNumber.text.toString(),
                keyboardFiveValue?.values?.get(0).toString(),
                keyboardFiveValue?.values?.get(1).toString()
            )
        }
    }

    private fun boxClick() {
        boxClickCount += 1
        if (passwords.size < 6) {
            when (boxClickCount) {
                0, 1 -> binding.layoutBoxSecret.boxOne.miniCircle.visibility = View.VISIBLE
                2 -> binding.layoutBoxSecret.boxTwo.miniCircle.visibility = View.VISIBLE
                3 -> binding.layoutBoxSecret.boxThree.miniCircle.visibility = View.VISIBLE
                4 -> binding.layoutBoxSecret.boxFour.miniCircle.visibility = View.VISIBLE
                5 -> binding.layoutBoxSecret.boxFive.miniCircle.visibility = View.VISIBLE
                6 -> binding.layoutBoxSecret.boxSix.miniCircle.visibility = View.VISIBLE
            }

            if (boxClickCount >= 6)
                binding.bntNext.isEnabled = true
        }
    }

    private fun boxClickDelete() {
        if (boxClickCount > 0) {
            when (boxClickCount) {
                0, 1 -> binding.layoutBoxSecret.boxOne.miniCircle.visibility = View.INVISIBLE
                2 -> binding.layoutBoxSecret.boxTwo.miniCircle.visibility = View.INVISIBLE
                3 -> binding.layoutBoxSecret.boxThree.miniCircle.visibility = View.INVISIBLE
                4 -> binding.layoutBoxSecret.boxFour.miniCircle.visibility = View.INVISIBLE
                5 -> binding.layoutBoxSecret.boxFive.miniCircle.visibility = View.INVISIBLE
                6 -> binding.layoutBoxSecret.boxSix.miniCircle.visibility = View.INVISIBLE

                else -> {
                    if (boxClickCount > 6) {
                        binding.layoutBoxSecret.boxSix.miniCircle.visibility = View.INVISIBLE
                        boxClickCount = 6
                        passwords.removeAt(5)
                    }
                }
            }

            boxClickCount -= 1
            if (boxClickCount in 0..5)
                passwords.removeAt(boxClickCount)

            binding.bntNext.isEnabled = false
        }
    }

    companion object {
        private const val CPF_CNPJ = "cpf_cnpj"
        fun newInstance(cpfCnpj: String) = PasswordFragment().apply {
            arguments = Bundle().apply {
                putString(CPF_CNPJ, cpfCnpj)
            }
        }
    }
}