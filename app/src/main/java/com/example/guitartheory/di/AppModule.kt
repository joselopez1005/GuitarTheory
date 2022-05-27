package com.example.guitartheory.di

import com.example.guitartheory.data.remote.UberchordApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	@Provides
	@Singleton
	fun providesUberchordApi(): UberchordApi {
		return Retrofit.Builder()
			.baseUrl(UberchordApi.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create()
	}

}