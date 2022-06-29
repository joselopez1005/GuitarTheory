package com.example.guitartheory.presentation.chord_search_result_screen

import com.example.guitartheory.domain.model.ChordDetailsFormatted
import com.example.guitartheory.domain.model.ChordFormatted

data class ChordSearchResultStates(
	val showNote: Boolean = false,
	val chord: ChordDetailsFormatted = ChordDetailsFormatted(listOf(), listOf(), listOf(), listOf())
)