package com.yapp.calculatorapplicaiton.di

import android.content.Context
import com.yapp.data.db.CalculatorDatabase
import com.yapp.data.db.dao.HistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {
    @Provides
    @Singleton
    fun provideCalculatorDB(
        @ApplicationContext context: Context
    ): CalculatorDatabase {
        return CalculatorDatabase.getCalculatorDatabase(context)
    }

    @Provides
    @Singleton
    fun provideHistoryDao(
        db: CalculatorDatabase
    ): HistoryDao {
        return db.historyDao()
    }
}