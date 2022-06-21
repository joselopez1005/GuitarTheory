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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.guitartheory.domain.model.ChordDetailsFormatted
import com.ramcosta.composedestinations.annotation.Destination


fun isOpen(fretPressed: String, fingerPosition: String): Boolean {
	return fretPressed == "0" && fingerPosition == "X"
}

fun isMuted(fretPressed: String, fingerPosition: String): Boolean {
	return fretPressed == "X" && fingerPosition == "X"
}

@Composable
@Destination
fun FretboardUpdated(
	chord: ChordDetailsFormatted,
	scale: Float,
	viewModel: FretboardViewModel = hiltViewModel()
) {
	viewModel.setChordDetailsState(chord, scale)

	val state = viewModel.states

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.padding(16.dp)
			.fillMaxWidth()
	) {
		for (string in 0 until state.chordDetails.strings.size) {
			Row {
				for (fret in 0..4) {
					val fretPressed = state.chordDetails.strings[string]
					val fingerPosition = state.chordDetails.fingering[string]
					if (!isOpen(fretPressed, fingerPosition) && !isMuted(
							fretPressed,
							fingerPosition
						)
					) {
						FretElement(
							fingerPosition = fingerPosition,
							fretPosition = fret,
							fretPressed = fretPressed,
							scale = state.scale
						)
					} else {
						FretElement(
							fretPosition = fret,
							scale = state.scale
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
	scale: Float
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
					.width((50 * scale).dp)
			)
			if (fingerPosition != null && fretPressed != null) {
				if (fretPressed.toInt() == fretPosition) {
					PressedSymbolElement(
						scale = scale,
						fingerPosition = fingerPosition,
						modifier = Modifier.align(Alignment.TopCenter)
					)
				}
			}
		}
		Divider(
			color = Color.Black,
			thickness = 2.dp,
			modifier = Modifier
				.height((30 * scale).dp)
				.width(2.dp)
		)
	}
}

@Composable
fun PressedSymbolElement(
	scale: Float,
	fingerPosition: String,
	modifier: Modifier = Modifier
) {
		Box(
			modifier = modifier
				.height((20 * scale).dp)
				.width((20 * scale).dp)
				.clip(CircleShape)
				.background(MaterialTheme.colors.primary),
			contentAlignment = Alignment.Center
		) {
			// Min size where text is still visible
			if( scale > 0.5f) {
				Text(
					text = fingerPosition,
					style = MaterialTheme.typography.body2,
					color = MaterialTheme.colors.onPrimary
				)
			}
		}
}




