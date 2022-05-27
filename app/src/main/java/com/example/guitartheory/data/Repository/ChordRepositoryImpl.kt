package com.example.guitartheory.data.Repository

import com.example.guitartheory.data.remote.UberchordApi
import com.example.guitartheory.domain.model.Chord
import com.example.guitartheory.domain.model.ChordDetails
import com.example.guitartheory.domain.repository.ChordRepository
import com.example.guitartheory.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ChordRepositoryImpl @Inject constructor(
	private val api: UberchordApi
) : ChordRepository {

	override suspend fun getChord(query: String): Flow<Resource<Chord>> {
		return flow {
			// Set loading to true
			emit(Resource.Loading(true))

			// API call
			val remoteChord =
				try {
					api.getChord(query)
				} catch (e: IOException) {
					e.printStackTrace()
					emit(Resource.Error("Couldn't load data"))
					null
				} catch (e: HttpException) {
					e.printStackTrace()
					emit(Resource.Error("Couldn't load data"))
					null
				}

			// Null check response
			remoteChord?.let {
				emit(Resource.Success(it))
			}

			// Set loading to false
			emit(Resource.Loading(false))
		}
	}

}