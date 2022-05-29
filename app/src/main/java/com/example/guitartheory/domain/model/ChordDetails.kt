package com.example.guitartheory.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChordDetails(
    val strings: String,
    val fingering: String,
    val chordName: String
) : Parcelable