package com.example.myapplication.di

import com.example.myapplication.network.ApiService
import com.example.myapplication.network.model.LoginStepOneMapper
import com.example.myapplication.network.model.LoginStepTwoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideStepOneMapper(): LoginStepOneMapper {
        return LoginStepOneMapper()
    }

    @Singleton
    @Provides
    fun provideStepTwoMapper(): LoginStepTwoMapper {
        return LoginStepTwoMapper()
    }
    @Singleton
    @Provides
    fun provideService(): ApiService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder().baseUrl("http://146.190.3.205/OAuth/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
            .build()
            .create(ApiService::class.java)
    }
}