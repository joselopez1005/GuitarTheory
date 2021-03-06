package com.example.guitartheory.presentation.fretboard

import com.example.guitartheory.domain.model.ChordDetailsFormatted

data class FretboardStates(
	val amountOfFrets: Int = 6,
	val scale: Float = 1f,
	val chordDetails: ChordDetailsFormatted = ChordDetailsFormatted(listOf(), listOf(), listOf(), listOf()),
	val fretPressed: List<String> = listOf(""),
	val currentTuning: List<String> = listOf("E", "A", "D", "G", "B", "E"),
	val showNote: Boolean = true
)
