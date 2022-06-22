package com.gmail.mtec.sistemas.businesscard.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.gmail.mtec.sistemas.businesscard.ui.NewBusinessCardActivity

class OpenActivitys {

    val newBusinessCardActivity: NewBusinessCardActivity = NewBusinessCardActivity()

    constructor() {

    }

    constructor(activityAtual: Activity, activityOpen: Activity) {
        val intent = Intent(activityAtual.applicationContext, activityOpen::class.java)
        activityAtual.startActivity(intent)

    }


}