package com.gmail.mtec.sistemas.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.mtec.sistemas.businesscard.R
import com.gmail.mtec.sistemas.businesscard.databinding.ActivityMainBinding
import com.gmail.mtec.sistemas.businesscard.util.OpenActivitys

class MainActivity : AppCompatActivity() {


    private lateinit var  binding:ActivityMainBinding// 1º forma de fazer o binding
    private val binding2 by lazy { ActivityMainBinding.inflate(layoutInflater) }//2ºforma de fazer o binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClicks()

    }

    private fun onClicks() {
        binding.fabNewCard.setOnClickListener {
            OpenActivitys(this,OpenActivitys().newBusinessCardActivity)
            //OpenActivitys(this,"imprimeir")
        }
    }
}