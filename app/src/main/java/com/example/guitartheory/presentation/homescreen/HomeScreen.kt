package com.example.guitartheory.presentation.homescreen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.guitartheory.R
import com.example.guitartheory.domain.model.DrawableStringPair
import com.example.guitartheory.presentation.destinations.ChordListScreenUpdatedDestination
import com.example.guitartheory.presentation.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
	navigation: DestinationsNavigator,
	viewModel: HomeScreenViewModel = hiltViewModel()
) {
	val state = viewModel.state
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp)
	) {
		HomeSection(
			title = R.string.resources,
			modifier = Modifier.fillMaxWidth()
		) {
			Row(
				horizontalArrangement = Arrangement.SpaceAround,
				modifier = Modifier.fillMaxWidth()
			) {
				ActivityCardItem(
					R.string.chord_search,
					R.drawable.chord_search,
					modifier = Modifier
						.padding(end = 8.dp)
						.clickable {
							navigation.navigate(
								ChordListScreenUpdatedDestination()
							)
						}
				)
				ActivityCardItem(
					R.string.fretboard_note,
					R.drawable.fretboard_note,
					modifier = Modifier
						.padding(end = 8.dp)
						.clickable {
						}
				)
			}
		}
		HomeSection(
			title = R.string.practice,
			modifier = Modifier.fillMaxWidth()
		) {
			ActivityShelfGrid(practiceCollectionData = state.practiceCollectionData)
		}

	}
}

@Composable
fun HomeSection(
	@StringRes title: Int,
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit
) {
	Column(modifier) {
		Text(
			text = stringResource(title).uppercase(),
			style = MaterialTheme.typography.h2,
			modifier = Modifier
				.paddingFromBaseline(top = 40.dp, bottom = 16.dp)
				.align(Alignment.CenterHorizontally)
		)
		content()
	}
}

@Composable
fun ActivityCardItem(
	@StringRes text: Int,
	@DrawableRes drawableRes: Int,
	modifier: Modifier = Modifier
) {
	Surface(
		shape = MaterialTheme.shapes.small,
		modifier = modifier
			.width(150.dp)
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier.padding(16.dp)
		) {
			Image(
				painter = painterResource(drawableRes),
				contentDescription = null,
				contentScale = ContentScale.Crop,
				modifier = Modifier
					.size(88.dp)
					.clip(CircleShape)
			)
			Text(
				text = stringResource(text),
				style = MaterialTheme.typography.h3,
				modifier = Modifier
					.paddingFromBaseline(
						top = 24.dp,
						bottom = 8.dp
					)
			)
		}
	}
}

@Composable
fun ActivityShelfGrid(
	practiceCollectionData: List<DrawableStringPair>,
	modifier: Modifier = Modifier
) {
	LazyHorizontalGrid(
		rows = GridCells.Fixed(2),
		contentPadding = PaddingValues(horizontal = 16.dp),
		horizontalArrangement = Arrangement.spacedBy(8.dp),
		verticalArrangement = Arrangement.spacedBy(8.dp),
		modifier = modifier.height(120.dp)
	) {
		items(practiceCollectionData) { item ->
			ActivityShelfItem(
				title = item.text,
				drawableRes = item.drawable
			)
		}
	}
}

@Composable
fun ActivityShelfItem(
	@StringRes title: Int,
	@DrawableRes drawableRes: Int,
	modifier: Modifier = Modifier
) {
	Surface(
		shape = MaterialTheme.shapes.small,
		modifier = modifier
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier.width(192.dp)
		) {
			Image(
				painter = painterResource(drawableRes),
				contentDescription = null,
				contentScale = ContentScale.Crop,
				modifier = Modifier
					.size(56.dp)
					.weight(1f)
			)
			Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier.weight(2f)
			) {
				Text(
					text = stringResource(title),
					style = MaterialTheme.typography.h3
				)
				Text(
					//TODO: Implement High Score Feature
					text = "High Score: 5",
					style = MaterialTheme.typography.body1
				)
			}
		}
	}
}


