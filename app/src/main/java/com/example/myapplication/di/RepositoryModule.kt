package com.example.myapplication.di

import com.example.myapplication.network.ApiService
import com.example.myapplication.network.model.LoginStepOneMapper
import com.example.myapplication.network.model.LoginStepTwoMapper
import com.example.myapplication.repository.GeneralRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideGeneralRepository(
        apiService: ApiService,
        stepOneMapper: LoginStepOneMapper,
        stepTwoMapper: LoginStepTwoMapper
    ): GeneralRepository {
        return GeneralRepository(apiService, stepOneMapper, stepTwoMapper)
    }
}