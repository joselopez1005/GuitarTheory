package com.example.guitartheory.presentation.fretboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.guitartheory.presentation.chord_list_screen.StringItem
import com.ramcosta.composedestinations.annotation.Destination

@Composable
fun FretBoard() {
	Column(modifier = Modifier.fillMaxSize()) {
		FretboardString()
		FretboardString()
		FretboardString()
		FretboardString()
		FretboardString()
		FretboardString()

	}
}

@Composable
fun FretboardString() {
	Row {
		StringItem(modifier = Modifier.weight(1f), isOpen = false, note = "F")
		StringItem(modifier = Modifier.weight(1f), isOpen = false, note = "F")
		StringItem(modifier = Modifier.weight(1f), isOpen = false, note = "F")
		StringItem(modifier = Modifier.weight(1f), isOpen = false, note = "F")
	}
}
