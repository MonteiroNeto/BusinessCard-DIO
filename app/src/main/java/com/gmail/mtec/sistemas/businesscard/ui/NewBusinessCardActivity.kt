package com.gmail.mtec.sistemas.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.gmail.mtec.sistemas.businesscard.App
import com.gmail.mtec.sistemas.businesscard.R
import com.gmail.mtec.sistemas.businesscard.data.BusinessCardModel
import com.gmail.mtec.sistemas.businesscard.databinding.ActivityNewBusinessCardBinding
import java.util.*


class NewBusinessCardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityNewBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewlModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onCLicks()
    }

    private fun onCLicks() {
        binding.ivClose.setOnClickListener {
            finish()
        }

        binding.btnConfirmar.setOnClickListener {
            val businessCard = BusinessCardModel(
                nome = binding.edtTexName.editText?.text.toString(),
                empresa = binding.edtTexEmpresa.editText?.text.toString(),
                telefone = binding.edtTexTelefone.editText?.text.toString(),
                email = binding.edtTexEmail.editText?.text.toString(),
                card_background = binding.edtTexCor.editText?.text.toString()
                    .uppercase(Locale.getDefault())
            )

            mainViewModel.insert(businessCard)
            Toast.makeText(this, getString(R.string.sucesso), Toast.LENGTH_SHORT).show()
            finish()

        }
    }
}



