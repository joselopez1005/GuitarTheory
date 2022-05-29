package com.example.guitartheory.presentation.fretboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.guitartheory.domain.model.ChordDetails
import com.example.guitartheory.domain.model.ChordDetailsFormatted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FretboardViewModel @Inject constructor() : ViewModel() {

	var states by mutableStateOf( FretboardStates() )

	fun setChordDetailsState(chordDetails: ChordDetailsFormatted) {
		states = states.copy(chordDetails = chordDetails)
	}
}