package com.yapp.calculatorapplicaiton.di

import com.yapp.data.source.HistoryLocalDataSource
import com.yapp.data.source.HistoryLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun bindHistoryLocalDataSource(
        historyLocalDataSourceImpl: HistoryLocalDataSourceImpl
    ): HistoryLocalDataSource
}