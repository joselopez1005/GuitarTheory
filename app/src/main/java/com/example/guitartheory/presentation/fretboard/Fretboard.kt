package com.example.guitartheory.presentation.fretboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.guitartheory.R
import com.example.guitartheory.domain.model.ChordDetailsFormatted
import com.example.guitartheory.util.FretboardHelper
import com.example.guitartheory.util.FretboardHelper.isMuted
import com.example.guitartheory.util.FretboardHelper.isOpen
import com.ramcosta.composedestinations.annotation.Destination

@Composable
fun FretboardUpdated(
	chord: ChordDetailsFormatted,
	scale: Float,
	showNote: Boolean,
	modifier: Modifier = Modifier,
	viewModel: FretboardViewModel = hiltViewModel()
) {
	viewModel.setChordDetailsState(chord, scale,showNote)

	val state = viewModel.states

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = modifier
	) {
		for (string in 0 until state.chordDetails.strings.size) {
			val fretPressed = state.chordDetails.strings[string]
			val fingerPosition = state.chordDetails.fingering[string]

			Row {
				// Beginning text for tuning
				Box(
					contentAlignment = Alignment.Center,
					modifier = Modifier
						.width(30.dp)
						.height((30 * scale).dp)
						.padding(end = 8.dp)
				) {
					Text(
						text = if (isMuted(fretPressed,fingerPosition)) stringResource(R.string.muted_string_symbol) else state.currentTuning[string],
						style = MaterialTheme.typography.body1,
					)
				}

				// Start of Fretboard representation
				for (fret in 0..4) {
					if (!isOpen(fretPressed, fingerPosition) && !isMuted(fretPressed, fingerPosition)) {
						val note = FretboardHelper.fingerPositionToNote(string, fretPressed.toInt())
						FretElement(
							fingerPosition = fingerPosition,
							fretPosition = fret,
							fretPressed = fretPressed,
							state = state,
							note = note
						)
					} else {
						FretElement(
							fretPosition = fret,
							state = state
						)
					}
				}
			}
		}
	}
}


@Composable
fun FretElement(
	modifier: Modifier = Modifier,
	fretPosition: Int,
	fretPressed: String? = null,
	fingerPosition: String? = null,
	note: String? = null,
	state: FretboardStates
) {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		modifier = modifier
	) {
		Box(
			contentAlignment = Alignment.Center
		) {
			Divider(
				color = Color.Black,
				thickness = 1.dp,
				modifier = Modifier
					.width((50 * state.scale).dp)
			)
			if (fingerPosition != null && fretPressed != null && note != null) {
				if (fretPressed.toInt() == fretPosition) {
					PressedSymbolElement(
						state = state,
						fingerPosition = fingerPosition,
						note = note,
						modifier = Modifier.align(Alignment.TopCenter)
					)
				}
			}
		}
		Divider(
			color = Color.Black,
			thickness = 2.dp,
			modifier = Modifier
				.height((30 * state.scale).dp)
				.width(2.dp)
		)
	}
}

@Composable
fun PressedSymbolElement(
	state: FretboardStates,
	fingerPosition: String,
	note: String,
	modifier: Modifier = Modifier
) {
	Box(
		modifier = modifier
			.height((20 * state.scale).dp)
			.width((20 * state.scale).dp)
			.clip(CircleShape)
			.background(MaterialTheme.colors.primary),
		contentAlignment = Alignment.Center
	) {
		// Min size where text is still visible
		if (state.scale > 0.7f) {
			if (state.showNote) {
				Text(
					text = note,
					style = MaterialTheme.typography.body2,
					color = MaterialTheme.colors.onPrimary
				)
			} else {
				Text(
					text = fingerPosition,
					style = MaterialTheme.typography.body2,
					color = MaterialTheme.colors.onPrimary
				)
			}
		}
	}
}





