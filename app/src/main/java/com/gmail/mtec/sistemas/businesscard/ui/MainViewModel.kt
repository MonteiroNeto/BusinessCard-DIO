package com.gmail.mtec.sistemas.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.mtec.sistemas.businesscard.data.BusinessCardModel
import com.gmail.mtec.sistemas.businesscard.data.BusinessCardRepository

class MainViewModel(private val businessCardRepository:BusinessCardRepository):ViewModel() {

    fun insert(businessCard: BusinessCardModel){
        businessCardRepository.insertTable(businessCard)
    }

    fun getAll():LiveData<List<BusinessCardModel>>{

        return businessCardRepository.getAll()
    }
}

class MainViewlModelFactory(private val repository: BusinessCardRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}