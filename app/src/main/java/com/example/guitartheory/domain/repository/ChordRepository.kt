package com.example.guitartheory.domain.repository

import com.example.guitartheory.domain.model.Chord
import com.example.guitartheory.domain.model.ChordDetails
import com.example.guitartheory.domain.model.ChordFormatted
import com.example.guitartheory.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChordRepository {

	suspend fun getChord(
		query: String
	): Flow<Resource<ChordFormatted>>

}