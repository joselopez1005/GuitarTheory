package com.example.guitartheory.presentation.chord_list_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guitartheory.domain.model.ChordDetails

@Composable
fun ChordItem(
	chord: ChordDetails,
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
					text = chord.chordName,
					fontWeight = FontWeight.SemiBold,
					fontSize = 16.sp,
					color = MaterialTheme.colors.onBackground,
					maxLines = 1,
					modifier = Modifier.weight(1f)
				)
				Spacer(modifier = Modifier.width(4.dp))
				Text(
					text = chord.fingering,
					fontWeight = FontWeight.SemiBold,
					color = MaterialTheme.colors.onBackground
				)
			}
		}
	}

}