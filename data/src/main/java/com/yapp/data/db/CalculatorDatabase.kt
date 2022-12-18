package com.yapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yapp.data.db.converters.ListConverter
import com.yapp.data.db.dao.HistoryDao
import com.yapp.data.db.entitry.CalculateHistoryEntity

@Database(entities = [CalculateHistoryEntity::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class CalculatorDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao

    companion object{
        private const val DATABASE_NAME = "Calculator.db"

        fun getCalculatorDatabase(context: Context): CalculatorDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                CalculatorDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}