package com.example.moviecatalog.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class MovieCatologViewModel : ViewModel() {

    // Holds the app's UI state
    private val _uiState = MutableStateFlow(MovieCatalogUIState())
    val uiState: StateFlow<MovieCatalogUIState> = _uiState.asStateFlow()



}