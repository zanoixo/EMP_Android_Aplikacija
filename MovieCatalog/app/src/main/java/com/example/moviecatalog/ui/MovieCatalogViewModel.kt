package com.example.moviecatalog.ui

import android.annotation.SuppressLint
import android.net.http.HttpException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalog.data.Movie
import com.example.moviecatalog.network.Api
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException


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

    fun setTop10() {
        viewModelScope.launch {
            try {
                val top100 = Api.retrofitService.get10()
                for (i in 0..9) {
                    _uiState.update {
                            currentState -> currentState.apply { topList.add(top100[i])}
                    }
                }
                Log.i("API", "Movie retrieved successfuly")
            } catch (e: IOException) {
                Log.e("API", "Error retrieving the quote - IO Exception: " + e.message)
            } catch (@SuppressLint("NewApi") e: HttpException) {
                Log.e("API", "Error retrieving the quote - HTTP Exception: " + e.message)
            }
        }
    }



}