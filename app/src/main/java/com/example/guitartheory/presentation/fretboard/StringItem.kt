package com.example.guitartheory.presentation.chord_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guitartheory.ui.theme.GuitarTheoryTheme

@Composable
fun StringItem(
	modifier: Modifier = Modifier,
	isOpen: Boolean,
	note: String,
) {
	Box(
		modifier = modifier,
		contentAlignment = Alignment.Center,
	) {
		Divider(
			color = Color.Black,
			thickness = 5.dp
		)
		Box(
			modifier = Modifier
				.padding(10.dp)
				.height(50.dp)
				.width(50.dp)
				.background(color = Color.Blue, shape = CircleShape),
			contentAlignment = Alignment.Center
		) {
			Text(
				text = note,
				color = Color.White,
				textAlign = TextAlign.Center,
			)
		}
	}
}