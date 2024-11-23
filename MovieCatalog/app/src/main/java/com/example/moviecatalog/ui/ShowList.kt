package com.example.moviecatalog.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moviecatalog.MovieCatalogScreen
import com.example.moviecatalog.data.Movie
import com.example.moviecatalog.data.availableMovies

@Composable
fun ShowListOfMovies(viewModel: MovieCatologViewModel = viewModel(),
                     navController: NavController,
                     screen: String) {
    val uiState = viewModel.uiState.collectAsState().value
    var index: Int = 0
    val movieList: ArrayList<Movie>
    if (screen == "Favorite") {
        index= uiState.favoriteIndex
        movieList = uiState.favorite
    }else {
        index = uiState.watchLaterIndex
        movieList = uiState.watchLater
    }
    for (i in 0..8) {
        if (movieList.size <= i) {
            break
        }
        Button(onClick = {

            viewModel.changeMovie(movieList[index * 9 + i])
            navController.navigate(MovieCatalogScreen.OpenMovie.name)
            }, modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(horizontal = 20.dp)) {
            Text(movieList[index * 9 + i].name)
        }
        Spacer(modifier = Modifier
            .height(20.dp))
        }
    }

