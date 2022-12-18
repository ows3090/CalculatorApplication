package com.yapp.calculatorapplicaiton.di

import com.yapp.domain.di.DefaultDispatcher
import com.yapp.domain.di.IODispatcher
import com.yapp.domain.di.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @IODispatcher
    fun provideIODispatcher(): CoroutineDispatcher{
        return Dispatchers.IO
    }

    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher{
        return Dispatchers.Default
    }

    @Provides
    @MainDispatcher
    fun provideMainDispatcher(): CoroutineDispatcher{
        return Dispatchers.Main
    }
}