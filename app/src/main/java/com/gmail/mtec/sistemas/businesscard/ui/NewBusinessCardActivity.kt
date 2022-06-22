package com.gmail.mtec.sistemas.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Button
import com.gmail.mtec.sistemas.businesscard.R
import com.gmail.mtec.sistemas.businesscard.databinding.ActivityNewBusinessCardBinding


class NewBusinessCardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityNewBusinessCardBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onCLicks()
    }

    private fun onCLicks() {
        binding.ivClose.setOnClickListener {
            finish()
        }
    }
}



