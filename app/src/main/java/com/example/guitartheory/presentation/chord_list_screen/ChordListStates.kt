package com.example.guitartheory.presentation.chord_list_screen

import com.example.guitartheory.domain.model.Chord
import com.example.guitartheory.domain.model.ChordDetails

data class ChordListStates(
	val chordList: Chord = Chord(),
	val isLoading: Boolean = false,
	val searchQuery: String = ""
)
