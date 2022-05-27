package com.example.guitartheory.presentation.chord_list_screen

sealed class ChordListEvent {
	data class OnSearchQueryChange(val query: String): ChordListEvent()
}