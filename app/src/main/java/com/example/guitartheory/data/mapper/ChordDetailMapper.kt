package com.example.guitartheory.data.mapper

import com.example.guitartheory.domain.model.ChordDetails
import com.example.guitartheory.domain.model.ChordDetailsFormatted

fun ChordDetails.toChordDetailsFormatted(): ChordDetailsFormatted {
	return ChordDetailsFormatted(
		strings = strings.split(" ").map { it -> it.trim() },
		fingering = fingering.split(" ").map { it -> it.trim() },
		chordName = chordName.split(",").map { it -> it.trim() }
	)
}