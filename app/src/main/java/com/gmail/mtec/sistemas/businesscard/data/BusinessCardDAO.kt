package com.gmail.mtec.sistemas.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BusinessCardDAO {

    @Query("SELECT * FROM BUSINESSCARDMODEL")
    fun getAll(): LiveData<List<BusinessCardModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTable (businessCardModel: BusinessCardModel)
}