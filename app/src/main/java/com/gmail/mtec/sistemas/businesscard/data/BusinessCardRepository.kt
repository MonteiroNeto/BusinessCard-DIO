package com.gmail.mtec.sistemas.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository(private val businessCardDAO: BusinessCardDAO) {

    fun insertTable (businessCardModel: BusinessCardModel) = runBlocking {
        launch (Dispatchers.IO){
            businessCardDAO.insertTable(businessCardModel)
        }
    }

    fun getAll() = businessCardDAO.getAll()
}