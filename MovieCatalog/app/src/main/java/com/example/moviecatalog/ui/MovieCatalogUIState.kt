package com.example.moviecatalog.ui

import com.example.moviecatalog.data.Movie

data class MovieCatalogUIState(
    val watchLater: List<Movie> = emptyList(),
    val favorite: List<Movie> = emptyList(),
)