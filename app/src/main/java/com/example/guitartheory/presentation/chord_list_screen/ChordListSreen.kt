package com.example.guitartheory.presentation.chord_list_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.guitartheory.domain.model.ChordDetailsFormatted
import com.ramcosta.composedestinations.annotation.Destination
import com.example.guitartheory.R
import com.example.guitartheory.presentation.destinations.FretboardUpdatedDestination
import com.example.guitartheory.presentation.fretboard.FretboardUpdated

import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun ChordListScreenUpdated(
	navigation: DestinationsNavigator,
	viewModel: ChordListingViewModel = hiltViewModel()
) {
	val state = viewModel.state
	Column(
		modifier = Modifier.padding(16.dp)
	) {
		ChordSearchTextField(state = state, viewModel = viewModel)

		LazyColumn(
			modifier = Modifier.fillMaxSize()
		) {
			items(state.chordList.chordDetailsFormattedList) { item ->
				ChordElement(chord = item, Modifier
					.fillMaxWidth()
					.clickable {
						navigation.navigate(FretboardUpdatedDestination(scale = 1f, chord = item))
					}
				)
			}
		}
	}
}

@Composable
fun ChordSearchTextField(
	state: ChordListStates,
	viewModel: ChordListingViewModel,
	modifier: Modifier = Modifier
) {
	OutlinedTextField(
		value = state.searchQuery,
		onValueChange = {
			viewModel.onEvent(ChordListEvent.OnSearchQueryChange(it))
		},
		leadingIcon = {
			Icon(
				imageVector = Icons.Default.Search,
				contentDescription = null
			)
		},
		singleLine = true,
		placeholder = {
			Text(stringResource(R.string.placeholder_search))
		},
		modifier = Modifier
			.fillMaxWidth()
			.heightIn(52.dp)
	)
}

@Composable
fun ChordElement(
	chord: ChordDetailsFormatted,
	modifier: Modifier = Modifier
) {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween,
		modifier = modifier
			.fillMaxWidth()
	) {
		Text(
			text = chord.chordName.toString(),
			style = MaterialTheme.typography.h3
		)
		FretboardUpdated(scale = 0.6f, chord = chord)
	}
}
