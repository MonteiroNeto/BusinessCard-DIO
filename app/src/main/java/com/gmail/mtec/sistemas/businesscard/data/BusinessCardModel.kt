package com.gmail.mtec.sistemas.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessCardModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nome: String,
    val empresa: String,
    val telefone: String,
    val email: String,
    val card_background: String,


    )