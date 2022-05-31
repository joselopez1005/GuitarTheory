package com.example.guitartheory.data.mapper

import com.example.guitartheory.domain.model.Chord
import com.example.guitartheory.domain.model.ChordDetails
import com.example.guitartheory.domain.model.ChordDetailsFormatted
import com.example.guitartheory.domain.model.ChordFormatted

fun Chord.toChordFormatted(): ChordFormatted {
	return ChordFormatted(
		map {
			it.toChordDetailsFormatted()
		})
}

fun ChordDetails.toChordDetailsFormatted(): ChordDetailsFormatted {
	return ChordDetailsFormatted(
		strings = strings.split(" ").map { it -> it.trim() },
		fingering = fingering.split(" ").map { it -> it.trim() },
		chordName = chordName.split(",").map { it.trim() }
	)
}