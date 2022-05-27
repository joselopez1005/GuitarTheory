package com.example.guitartheory.domain.model

import com.google.gson.annotations.SerializedName

data class ChordDetails(
    val strings: String,

    val fingering: String,

    val chordName: String
)