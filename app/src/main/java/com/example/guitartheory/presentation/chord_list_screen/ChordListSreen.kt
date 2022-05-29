package com.example.guitartheory.presentation.chord_list_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.guitartheory.presentation.destinations.FretBoardDestination
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
			items(state.chordList.size) { i ->
				val currentChord = state.chordList[i]
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