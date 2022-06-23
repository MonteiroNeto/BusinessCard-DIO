package com.gmail.mtec.sistemas.businesscard

import android.app.Application
import com.gmail.mtec.sistemas.businesscard.data.BusinessCardDAO
import com.gmail.mtec.sistemas.businesscard.data.BusinessCardRepository
import com.gmail.mtec.sistemas.businesscard.data.DatabaseHelper

class App: Application() {
    val dbHelper by lazy { DatabaseHelper.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(dbHelper.businessCardDao()) }


}