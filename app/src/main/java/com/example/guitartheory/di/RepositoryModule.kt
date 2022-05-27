package com.example.guitartheory.di

import com.example.guitartheory.data.Repository.ChordRepositoryImpl
import com.example.guitartheory.domain.repository.ChordRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

	@Binds
	@Singleton
	abstract fun bindChordRepository(
		chordRepositoryImpl: ChordRepositoryImpl
	): ChordRepository
}