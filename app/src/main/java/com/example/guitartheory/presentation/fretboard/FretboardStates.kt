package com.example.guitartheory.presentation.fretboard

import com.example.guitartheory.domain.model.ChordDetails

data class FretboardStates(
	val amountOfFrets: Int = 6,
	val chordDetails: ChordDetails = ChordDetails("X 3 2 0 1 0", "X 3 2 X 1 X", "C,,,"),
	val fretPressed: List<String> = listOf("")
)
