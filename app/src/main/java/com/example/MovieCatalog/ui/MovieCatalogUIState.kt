package com.example.MovieCatalog.ui

import com.example.MovieCatalog.data.Movie

data class MovieCatalogUIState(
    val watchLater: List<Movie> = emptyList(),
    val favorite: List<Movie> = emptyList(),
)