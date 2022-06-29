package com.example.guitartheory.presentation.chord_search_result_screen

import android.graphics.Paint
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.guitartheory.R
import com.example.guitartheory.domain.model.ChordDetailsFormatted
import com.example.guitartheory.presentation.fretboard.FretboardUpdated
import com.example.guitartheory.ui.theme.gray900
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun ChordSearchResultScreen(
	chord: ChordDetailsFormatted,
	viewModel: ChordSearchResultViewModel = hiltViewModel()
) {
	viewModel.setChordDetails(chord)
	val state = viewModel.state

	Column(
		modifier = Modifier
			.padding(16.dp)
			.fillMaxSize()
	) {
		FretboardSection(
			state = state,
			viewModel = viewModel
		)
		AdditionalDetailsSection(
			state = state,
			modifier = Modifier
				.clip(MaterialTheme.shapes.small)
				.background(Color.LightGray)
				.fillMaxWidth()
				.padding(32.dp)
		)

	}
}

@Composable
fun FretboardSection(
	state: ChordSearchResultStates,
	viewModel: ChordSearchResultViewModel,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
	) {
		Text(
			text = state.chord.chordName.toString(),
			style = MaterialTheme.typography.h1,
			modifier = Modifier
				.padding(bottom = 8.dp)
				.align(Alignment.CenterHorizontally)
		)
		FretboardUpdated(
			chord = state.chord,
			scale = 1f,
			showNote = state.showNote,
			modifier = Modifier
				.fillMaxWidth()
		)
		NoteToggleButton(
			state = state,
			viewModel = viewModel,
		)
	}
}

@Composable
fun NoteToggleButton(
	state: ChordSearchResultStates,
	viewModel: ChordSearchResultViewModel,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
	) {
		Switch(
			checked = state.showNote,
			onCheckedChange = {
				viewModel.onEvent(ChordSearchResultEvent.OnShowNoteToggle(it))
			}
		)
		Text(
			text = stringResource(R.string.show_notes),
			style = MaterialTheme.typography.body1
		)
	}
}

@Composable
fun AdditionalDetailsSection(
	state: ChordSearchResultStates,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
	) {
		Text(
			text = "Details",
			style = MaterialTheme.typography.h1,
			color = gray900,
			modifier = Modifier
				.padding(bottom = 16.dp)
				.align(Alignment.CenterHorizontally)
		)
		DetailItem(sectionName = R.string.shorthand_notation, detailList = state.chord.strings, Modifier.padding(bottom = 30.dp))
		DetailItem(sectionName = R.string.tones, detailList = state.chord.tones)
	}
}

@Composable
fun DetailItem(
	@StringRes sectionName: Int,
	detailList: List<String>,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
	) {
		Text(
			text = stringResource(id = sectionName),
			style = MaterialTheme.typography.h2,
			color = gray900
		)
		Spacer(modifier = Modifier.height(15.dp))
		Text(
			text = detailList.toString(),
			style = MaterialTheme.typography.h3,
			color = gray900
		)
	}
}