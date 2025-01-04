package com.example.moviecatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moviecatalog.ui.theme.MovieCatalogTheme
import com.example.moviecatalog.ui.MovieCatalogViewModel
import com.example.moviecatalog.ui.MovieCatalogViewModelFactory

private const val TAG = "MyActivity"



class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MovieCatalogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "On create called")

        enableEdgeToEdge()
        val repository = (application as MovieCatalogApplication).repository.movieCatalogRepository

        // Initialize the ViewModel using the factory
        val viewModelFactory = MovieCatalogViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieCatalogViewModel::class.java)
        setContent {
            MovieCatalogTheme {
                MovieCatalogApp(viewModel = viewModel)
            }

        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }
}
