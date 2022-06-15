package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.myapplication.ui.main.MainFragment
import com.example.myapplication.ui.password.PasswordFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    companion object {
        fun goToFragment(
            fragmentManager: FragmentManager?,
            fragment: Fragment,
            bundle: Bundle? = null
        ) {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.container, fragment)
                ?.commitNow()
        }
    }
}