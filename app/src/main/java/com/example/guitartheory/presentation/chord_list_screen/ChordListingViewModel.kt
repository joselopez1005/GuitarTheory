package com.example.guitartheory.presentation.chord_list_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.guitartheory.domain.repository.ChordRepository
import com.example.guitartheory.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChordListingViewModel @Inject constructor(
	private val repository: ChordRepository
) : ViewModel() {

	var state by mutableStateOf(ChordListStates())
	private var searchJob: Job? = null

	init {
		getChord()
	}

	fun onEvent(event: ChordListEvent) {
		when (event) {
			is ChordListEvent.OnSearchQueryChange -> {
				state = state.copy(searchQuery = event.query)
				searchJob?.cancel()
				searchJob = viewModelScope.launch {
					delay(500L)
					getChord(state.searchQuery)
				}
			}
		}
	}

	private fun getChord(
		query: String = state.searchQuery
	) {
		viewModelScope.launch {
			repository.getChord(query)
				.collect { result ->
					when (result) {
						is Resource.Success -> {
							result.data?.let {
								state = state.copy(
									chordList = it
								)
							}
						}
						is Resource.Error -> Unit
						is Resource.Loading -> {
							state = state.copy(isLoading = result.isLoading)
						}
					}

				}
		}
	}
}