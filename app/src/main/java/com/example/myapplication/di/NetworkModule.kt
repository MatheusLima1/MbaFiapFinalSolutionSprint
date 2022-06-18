package com.example.myapplication.di

import com.example.myapplication.network.ApiService
import com.google.gson.GsonBuilder
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object NetworkModule {
    @Singleton
    @Provides
    fun provideService(): ApiService {
        return Retrofit.Builder().baseUrl("https://localhost:7144/OAuth/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiService::class.java)
    }
}