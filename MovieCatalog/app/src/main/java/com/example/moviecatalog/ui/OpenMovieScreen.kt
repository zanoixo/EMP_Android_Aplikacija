package com.example.moviecatalog.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

@Composable
fun inWatchList(viewModel:  MovieCatologViewModel): Int {
    val uiState = viewModel.uiState.collectAsState().value
    for (movie: Movie in uiState.watchLater) {
        if (movie == uiState.currentMovie) {
            return 1
        }
    }
    return 0

}

@Composable
fun inFavoriteList(viewModel: MovieCatologViewModel): Int{
    val uiState = viewModel.uiState.collectAsState().value
    for (movie: Movie in uiState.favorite) {
        if (movie == uiState.currentMovie) {
            return 1
        }
    }
    return 0
}

@Composable
fun OpenMovieScreen(viewModel: MovieCatologViewModel = viewModel(),
                    navController: NavController) {

    val uiState = viewModel.uiState.collectAsState().value
    val isInFavoriteList : Int = inFavoriteList(viewModel)
    val isInWatchLaterList : Int = inWatchList(viewModel)

    Column(Modifier.padding(vertical = 28.dp).fillMaxWidth()
    ){
        Text(uiState.currentMovie.name, fontSize = 48.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(10.dp))
        Text("Description: ", fontSize = 24.sp, modifier = Modifier.padding(start = 10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Text(uiState.currentMovie.description, modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth().padding(horizontal = 30.dp))
        Spacer(modifier = Modifier.height(20.dp))


        if (isInFavoriteList == 0) {
            Button(onClick = {viewModel.addMovieToFavoriteList(uiState.currentMovie)
                              navController.navigate(MovieCatalogScreen.OpenMovie.name)
                             }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text("Add to favorites")
            }
        }else {
            Button(onClick = {viewModel.removeMovieFromFavoriteList(uiState.currentMovie)
                navController.navigate(MovieCatalogScreen.OpenMovie.name)}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text("Remove from favorites")
            }
        }

        if (isInWatchLaterList == 0) {
            Button(onClick = {viewModel.addMovieToWatchLaterList(uiState.currentMovie)
                navController.navigate(MovieCatalogScreen.OpenMovie.name)}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text("Add to Watch later")
            }
        }else {
            Button(onClick = {viewModel.removeMovieFromWatchLaterList(uiState.currentMovie)
                navController.navigate(MovieCatalogScreen.OpenMovie.name)}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text("Remove from Watch later")
            }
        }


        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {navController.navigate(MovieCatalogScreen.Home.name)}, modifier = Modifier.padding(start = 20.dp).padding(bottom = 20.dp)) {
            Text("Back")
        }
    }
}