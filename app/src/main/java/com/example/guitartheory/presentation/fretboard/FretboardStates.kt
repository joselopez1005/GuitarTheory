package com.example.guitartheory.presentation.fretboard

import com.example.guitartheory.domain.model.ChordDetails
import com.example.guitartheory.domain.model.ChordDetailsFormatted

data class FretboardStates(
	val amountOfFrets: Int = 6,
	val chordDetails: ChordDetailsFormatted = ChordDetailsFormatted(listOf(), listOf(), "listOf()"),
	val fretPressed: List<String> = listOf("")
)
