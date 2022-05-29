package com.example.guitartheory.presentation.chord_list_screen

import com.example.guitartheory.domain.model.Chord

data class ChordListStates(
	val chordList: Chord = Chord(),
	val isLoading: Boolean = false,
	val searchQuery: String = ""
)
