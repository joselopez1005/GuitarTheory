package com.example.guitartheory.presentation.chord_search_result_screen

sealed class ChordSearchResultEvent {
	data class OnShowNoteToggle(val showNote: Boolean): ChordSearchResultEvent()
}