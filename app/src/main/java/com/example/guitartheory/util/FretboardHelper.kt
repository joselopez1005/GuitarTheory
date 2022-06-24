package com.example.guitartheory.util

object FretboardHelper {

	val string2DArray: Array<Array<String>> = arrayOf(
		arrayOf("E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#"),
		arrayOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"),
		arrayOf("D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#"),
		arrayOf("G", "G#", "A", "A#,", "B", "C", "C#", "D", "D#", "E", "F", "F#"),
		arrayOf("B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#"),
		arrayOf("E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#")
	)

	fun isOpen(fretPressed: String, fingerPosition: String): Boolean {
		return fretPressed == "0" && fingerPosition == "X"
	}

	fun isMuted(fretPressed: String, fingerPosition: String): Boolean {
		return fretPressed == "X" && fingerPosition == "X"
	}

	fun fingerPositionToNote(string: Int, fretPressed: Int): String{
		return string2DArray[string][fretPressed]
	}
}