package com.example.moviecatalog.ui

import androidx.lifecycle.ViewModel
import com.example.moviecatalog.data.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MovieCatologViewModel : ViewModel() {

    // Holds the app's UI state
    private val _uiState = MutableStateFlow(MovieCatalogUIState())
    val uiState: StateFlow<MovieCatalogUIState> = _uiState.asStateFlow()

    fun changeFavoriteIndex(changePage: Int) {
        _uiState.update {
                currentState -> currentState.copy(favoriteIndex = _uiState.value.favoriteIndex + changePage)
        }
    }

    fun changeWatchLaterIndex(changePage: Int) {
        _uiState.update {
                currentState -> currentState.copy(watchLaterIndex = _uiState.value.watchLaterIndex + changePage)
        }
    }

    fun changeHomeIndex(changePage: Int) {
        _uiState.update {
                currentState -> currentState.copy(homeIndex = _uiState.value.homeIndex + changePage)
        }
    }

    fun changeMovie(movie: Movie) {
        _uiState.update {
                currentState -> currentState.copy(currentMovie = movie)
        }
    }

    fun addMovieToFavoriteList(movie: Movie) {
        _uiState.update {
            currentState -> currentState.apply { favorite.add(movie)}
        }
    }

    fun addMovieToWatchLaterList(movie: Movie) {
        _uiState.update {
                currentState -> currentState.apply { watchLater.add(movie)}
        }
    }

    fun removeMovieFromFavoriteList(movie: Movie) {
        _uiState.update {
                currentState -> currentState.apply { favorite.remove(movie)}
        }
    }

    fun removeMovieFromWatchLaterList(movie: Movie) {
        _uiState.update {
                currentState -> currentState.apply { watchLater.remove(movie)}
        }
    }



}