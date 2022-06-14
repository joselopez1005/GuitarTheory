package com.example.guitartheory.presentation.fretboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.guitartheory.domain.model.ChordDetailsFormatted
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun FretBoard(
	modifier: Modifier = Modifier,
	chordDetails: ChordDetailsFormatted,
	fretboardViewModel: FretboardViewModel = hiltViewModel(),
) {
	fretboardViewModel.setChordDetailsState(chordDetails)
	val states = fretboardViewModel.states

	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(20.dp)
	) {
		for (currString in 0 until states.chordDetails.strings.size) {
			Row(
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Text(
					text = states.currentTuning[currString],
					modifier = Modifier
						.weight(0.4f)
				)
				CompleteString(
					fretPressed = states.chordDetails.strings[currString],
					fingerPosition = states.chordDetails.fingering[currString],
					amountOfFret = states.amountOfFrets,
					modifier = Modifier.weight(9.6f)
				)
			}
		}
	}
}

@Composable
fun CompleteString(
	fretPressed: String,
	fingerPosition: String,
	amountOfFret: Int,
	modifier: Modifier = Modifier
) {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceAround,
		modifier = modifier
	) {
		for(fret in 0 until amountOfFret) {
			if(!isOpen(fretPressed, fingerPosition) && !isMuted(fretPressed, fingerPosition)) {
				FretItem(
					modifier = Modifier
						.height(30.dp)
						.weight(1f),
					fingerPosition = fingerPosition,
					fretPosition = fret,
					fretPressed = fretPressed
				)
			} else {
				FretItem(
					modifier = Modifier
						.height(30.dp)
						.weight(1f),
					fretPosition = fret
				)
			}
		}
	}

}

@Composable
fun FretItem(
	modifier: Modifier = Modifier,
	fretPosition: Int,
	fretPressed: String? = null,
	fingerPosition: String? = null
) {
	Box(
		contentAlignment = Alignment.Center,
		modifier = modifier
	) {
		Divider(
			color = Color.Black,
			modifier = Modifier
				.fillMaxWidth()
				.height(3.dp)
		)
		if(fretPosition != 0) {
			Divider(
				color = Color.Black,
				modifier = Modifier
					.fillMaxHeight()
					.width(5.dp)
					.align(Alignment.TopStart)
			)
		}
		if (fingerPosition != null && fretPressed != null) {
			if(fretPressed.toInt() == fretPosition) {
				PressedSymbol(fingerPosition = fingerPosition)
			}
		}
	}
}

@Composable
fun PressedSymbol(
	fingerPosition: String,
	modifier: Modifier = Modifier
) {
	Box(
		modifier = modifier
			.height(20.dp)
			.width(20.dp)
			.clip(CircleShape)
			.background(Color.Red),
		contentAlignment = Alignment.Center,
	) {
		Text(
			text = fingerPosition,
		)
	}
}

@Composable
@Preview(showBackground = true)
fun FretboardPreview() {
	FretBoard(
		chordDetails = ChordDetailsFormatted(
			chordName = listOf("C"),
			strings = listOf("X", "3", "2", "0", "1", "0"),
			fingering = listOf("X", "3", "2", "X", "1", "X")
		)
	)
}

fun isOpen(fretPressed: String, fingerPosition: String): Boolean {
	return fretPressed == "0" && fingerPosition == "X"
}

fun isMuted(fretPressed: String, fingerPosition: String): Boolean {
	return fretPressed == "X" && fingerPosition == "X"
}




