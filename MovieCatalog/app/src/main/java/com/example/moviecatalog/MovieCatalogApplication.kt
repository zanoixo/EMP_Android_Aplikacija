package com.example.moviecatalog

import AppContainer
import AppDataContainer
import android.app.Application
import com.example.moviecatalog.data.MovieCatalogDatabase

class MovieCatalogApplication : Application() {


    //The instance of AppContainer is used by other
    // classes to obtain dependencies.
    lateinit var repository: AppContainer

    override fun onCreate() {
        super.onCreate()
        val database = MovieCatalogDatabase.getDatabase(this)
        repository = AppDataContainer(this)
    }
}