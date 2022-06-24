package com.example.guitartheory.presentation.chord_search_result_screen

import androidx.compose.runtime.Composable
import com.example.guitartheory.domain.model.ChordDetailsFormatted
import com.example.guitartheory.presentation.fretboard.FretboardUpdated
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun ChordSearchResultScreen(
	chord: ChordDetailsFormatted
) {
	FretboardUpdated(chord = chord, scale = 1f)

}