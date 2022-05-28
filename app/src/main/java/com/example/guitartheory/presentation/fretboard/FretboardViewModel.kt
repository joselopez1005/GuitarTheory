package com.example.guitartheory.presentation.fretboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FretboardViewModel @Inject constructor() : ViewModel() {

	val states by mutableStateOf( FretboardStates() )
}