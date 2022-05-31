package com.example.guitartheory.presentation.chord_list_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.guitartheory.domain.model.ChordDetailsFormatted
import com.example.guitartheory.presentation.destinations.FretBoardDestination
import com.example.guitartheory.presentation.fretboard.FretBoard
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph( start = true )
@Composable
@Destination
fun ChordListScreen(
	navigation: DestinationsNavigator,
	viewModel: ChordListingViewModel = hiltViewModel()
) {
	val state = viewModel.state
	Column(
		Modifier.fillMaxSize()
	) {
		OutlinedTextField(
			value = state.searchQuery,
			onValueChange = {
				viewModel.onEvent(
					ChordListEvent.OnSearchQueryChange(it)
				)
			},
			modifier = Modifier
				.padding(16.dp)
				.fillMaxWidth(),
			placeholder = {
				Text(text = "Search...")
			},
			maxLines = 1,
			singleLine = true
		)
		LazyColumn(
			modifier = Modifier.fillMaxSize()
		) {
			items(state.chordList.chordDetailsFormattedList.size) { i ->
				val currentChord = state.chordList.chordDetailsFormattedList[i]
				ChordItem(
					chord = currentChord,
					modifier = Modifier
						.fillMaxWidth()
						.padding(16.dp)
						.clickable {
							navigation.navigate(
								FretBoardDestination(currentChord)
							)
						}
				)

			}
		}

	}
}

@Composable
fun ChordItem(
	chord: ChordDetailsFormatted,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
	) {
		Column(
			modifier = Modifier.weight(1f)
		) {
			Row(
				modifier = modifier.fillMaxWidth()
			) {
				Text(
					text = chord.chordName.joinToString(" "),
					fontWeight = FontWeight.SemiBold,
					fontSize = 16.sp,
					color = MaterialTheme.colors.onBackground,
					maxLines = 1,
					modifier = Modifier.weight(1f)
				)
//				Text(
//					text = chord.fingering.toString(),
//					fontWeight = FontWeight.SemiBold,
//					color = MaterialTheme.colors.onBackground
//				)
				FretBoard(
					Modifier
						.weight(9f),
					chordDetails = chord
				)
			}
		}
	}
}