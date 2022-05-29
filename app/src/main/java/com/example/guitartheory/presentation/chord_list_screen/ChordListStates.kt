package com.example.guitartheory.presentation.chord_list_screen

import com.example.guitartheory.domain.model.Chord
import com.example.guitartheory.domain.model.ChordFormatted

data class ChordListStates(
	val chordList: ChordFormatted = ChordFormatted(listOf()),
	val isLoading: Boolean = false,
	val searchQuery: String = ""
)
