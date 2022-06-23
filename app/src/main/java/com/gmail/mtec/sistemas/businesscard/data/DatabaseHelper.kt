package com.gmail.mtec.sistemas.businesscard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.sql.DatabaseMetaData

@Database(entities = [BusinessCardModel::class], version = 1)
abstract class DatabaseHelper : RoomDatabase() {

    abstract fun businessCardDao(): BusinessCardDAO


    companion object{
        @Volatile
        private var INSTANCE:DatabaseHelper? = null

        fun getDatabase(context: Context):DatabaseHelper{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseHelper::class.java,
                    "business_card_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }


    }
}