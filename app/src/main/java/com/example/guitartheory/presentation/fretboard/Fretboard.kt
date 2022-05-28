package com.example.guitartheory.presentation.fretboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.guitartheory.presentation.chord_list_screen.StringItem
import com.ramcosta.composedestinations.annotation.Destination

@Composable
fun FretBoard(
	fretboardViewModel: FretboardViewModel = hiltViewModel()
) {
	val states = fretboardViewModel.states
	Column(modifier = Modifier.fillMaxSize()) {
		for(i in 1..6) {
			CompleteString(amountOfFrets = states.amountOfFrets)
		}
	}
}

@Composable
fun CompleteString(
	modifier: Modifier = Modifier,
	amountOfFrets: Int
) {
	Row {
		for (fret in 1..amountOfFrets) {
			StringItem(modifier = modifier.weight(1f), isOpen = false, note = "F")
		}
	}
}


