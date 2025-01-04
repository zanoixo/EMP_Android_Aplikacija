package com.example.moviecatalog.data

interface MovieCatalogRepository {

    suspend fun getFavoriteList(): List<Movie>
    suspend fun removeFavorite(name: String)
    suspend fun addFavorite(movie: FavoriteEntity)
    suspend fun getFavoriteBelow5(): List<Movie>

    suspend fun getWatchLaterList(): List<Movie>
    suspend fun removeWatchLater(name: String)
    suspend fun addWatchLater(movie: WatchLaterEntity)
    suspend fun getWatchLaterAbove5(): List<Movie>

}