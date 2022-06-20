package com.example.myapplication.presentation.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.presentation.ui.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.presentation.ui.password.PasswordFragment

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    private var isChecked = false
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentMainBinding.bind(inflater.inflate(R.layout.fragment_main, container, false))
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        binding.recaptchaLayout.chbEnableCaptcha.setOnCheckedChangeListener { compoundButton, isChecked ->
            this.isChecked = isChecked
            checkCanGoThrough(isChecked)
        }
        binding.edtCnpjCpf.addTextChangedListener (object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                checkCanGoThrough(isChecked)
            }
        })
        binding.btnSignIn.setOnClickListener {
            MainActivity.goToFragment(fragmentManager, PasswordFragment.newInstance(binding.edtCnpjCpf.text.toString()))
        }
    }

    private fun checkCanGoThrough(isChecked: Boolean) {
        if (isChecked) {
            binding.btnSignIn.isEnabled = binding.edtCnpjCpf.text.length >= 11
        } else {
            binding.btnSignIn.isEnabled = false
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}