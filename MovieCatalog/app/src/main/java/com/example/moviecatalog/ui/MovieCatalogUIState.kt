package com.example.moviecatalog.ui

import com.example.moviecatalog.data.Movie

data class MovieCatalogUIState(
    var watchLater: ArrayList<Movie> = ArrayList<Movie>(),
    var favorite: ArrayList<Movie> = ArrayList<Movie>(),
    var homeIndex: Int = 0,
    var currentMovie: Movie = Movie("",0,0.0, ""),
    var favoriteIndex: Int = 0,
    var watchLaterIndex: Int = 0,

)