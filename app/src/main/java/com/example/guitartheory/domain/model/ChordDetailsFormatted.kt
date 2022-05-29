package com.example.guitartheory.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChordDetailsFormatted (
	val strings: List<String>,
	val fingering: List<String>,
	val chordName: String
) : Parcelable