package com.example.moviecatalog.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moviecatalog.MovieCatalogScreen
import com.example.moviecatalog.data.Movie
import com.example.moviecatalog.data.availableMovies
import kotlin.math.abs

fun getClosestMovie(uiState: MovieCatalogUIState): Movie {
    var avg: Int = 0

    for (i in 0..<uiState.favorite.count()) {
        avg += uiState.favorite[i].year
    }
    avg /= uiState.favorite.count()
    var bestChoice: Movie = availableMovies[0]
    for (i in 0..<availableMovies.count()) {
        if (abs(availableMovies[i].year - avg) < abs(bestChoice.year - avg)) {
            bestChoice = availableMovies[i]
        }
    }
    return bestChoice
}

@Composable
fun RecommendationScreen(viewModel: MovieCatalogViewModel = viewModel(),
                         navController: NavController) {
    val uiState = viewModel.uiState.collectAsState().value
    Column(
        Modifier.padding(vertical = 28.dp).fillMaxWidth()
    ){
        Text("Recommended movie",  modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(10.dp))
        var recommendedMovie: Movie = getClosestMovie(uiState)
        Button(onClick = {
            viewModel.changeMovie(recommendedMovie)
            navController.navigate(MovieCatalogScreen.OpenMovie.name)}, modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(horizontal = 20.dp)) {
            Text(recommendedMovie.name)
        }




        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {navController.navigate(MovieCatalogScreen.Favorite.name)}, modifier = Modifier.padding(start = 20.dp).padding(bottom = 20.dp)) {
            Text("Back")
        }
    }
}