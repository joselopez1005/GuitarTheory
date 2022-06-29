package com.example.guitartheory.presentation.chord_search_result_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.guitartheory.domain.model.ChordDetailsFormatted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChordSearchResultViewModel @Inject constructor(): ViewModel() {
	var state by mutableStateOf(ChordSearchResultStates())

	fun onEvent(event: ChordSearchResultEvent) {
		when (event) {
			is ChordSearchResultEvent.OnShowNoteToggle -> {
				state = state.copy(showNote = event.showNote)
			}
		}
	}

	fun setChordDetails(chordDetailsFormatted: ChordDetailsFormatted) {
		state = state.copy(chord = chordDetailsFormatted)
	}

}