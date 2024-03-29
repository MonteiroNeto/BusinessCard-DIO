package com.gmail.mtec.sistemas.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.mtec.sistemas.businesscard.App
import com.gmail.mtec.sistemas.businesscard.databinding.ActivityMainBinding
import com.gmail.mtec.sistemas.businesscard.util.ScreenShotCardForShare
import com.gmail.mtec.sistemas.businesscard.util.OpenActivitys

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding// 1º forma de fazer o binding
    //private val binding2 by lazy { ActivityMainBinding.inflate(layoutInflater) }//2ºforma de fazer o binding

    private val mainViewModel: MainViewModel by viewModels {
        MainViewlModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinessCardAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAllBusinessCard()
        val layout = LinearLayoutManager(this)
        binding.rvCards.layoutManager = layout
        binding.rvCards.adapter = adapter
        onClicks()

    }

    private fun onClicks() {
        binding.fabNewCard.setOnClickListener {
            OpenActivitys(this, OpenActivitys().newBusinessCardActivity)
            //OpenActivitys(this,"imprimeir")
        }

        adapter.listenerShare = { card ->
            ScreenShotCardForShare.share(this@MainActivity,card)

        }
    }

    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this) {
            adapter.submitList(it)
        }
    }

}