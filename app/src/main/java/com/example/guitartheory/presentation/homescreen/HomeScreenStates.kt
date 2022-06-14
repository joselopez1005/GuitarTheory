package com.example.guitartheory.presentation.homescreen

import com.example.guitartheory.R
import com.example.guitartheory.domain.model.DrawableStringPair

data class HomeScreenStates(
	val practiceCollectionData: List<DrawableStringPair> = listOf(
		R.drawable.note_identification to R.string.note_identification,
		R.drawable.interval_identification to R.string.interval_identification,
		R.drawable.chord_identification to R.string.chord_identification,
		R.drawable.scale_identification to R.string.scale_identification,
	).map { DrawableStringPair(it.first, it.second) }
)
