package com.yapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yapp.data.db.dao.HistoryDao
import com.yapp.data.db.entitry.CalculateHistoryEntity

@Database(
    entities = [CalculateHistoryEntity::class],
    version = 1
)
abstract class CalculatorDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao

    companion object{
        private var _instance: CalculatorDatabase? = null
        private val lock = Any()
        private const val DATABASE_NAME = "Calculator.db"

        fun getCalculatorDatabase(context: Context): CalculatorDatabase {
            if (_instance == null) {
                synchronized(lock) {
                    if(_instance == null){
                        _instance = Room.databaseBuilder(
                            context.applicationContext,
                            CalculatorDatabase::class.java,
                            DATABASE_NAME
                        ).build()
                    }
                }
            }

            return _instance!!
        }
    }
}