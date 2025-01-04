package com.example.moviecatalog.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviecatalog.data.MovieCatalogRepository


//Provides Factory to create instance of ViewModel for the entire app
class MovieCatalogViewModelFactory(private val repository: MovieCatalogRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieCatalogViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieCatalogViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}