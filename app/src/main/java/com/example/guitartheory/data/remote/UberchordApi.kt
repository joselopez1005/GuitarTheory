package com.example.guitartheory.data.remote

import com.example.guitartheory.domain.model.Chord
import com.example.guitartheory.domain.model.ChordDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UberchordApi {

	@GET("v1/chords")
	suspend fun getChord(@Query("nameLike") query:String) : Chord

	companion object {
		const val BASE_URL = "https://api.uberchord.com"
	}
}