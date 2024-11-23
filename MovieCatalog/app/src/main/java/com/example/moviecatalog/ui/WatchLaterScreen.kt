package com.example.moviecatalog.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moviecatalog.MovieCatalogScreen

@Composable
fun WatchLaterScreen(viewModel: MovieCatologViewModel = viewModel(),
                     navController: NavController) {
    val uiState = viewModel.uiState.collectAsState().value;
    Column{
        TopBar(viewModel = viewModel, navController = navController)
        Text("Watch later screen", modifier = Modifier.align(Alignment.CenterHorizontally))
        ShowListOfMovies(viewModel = viewModel, navController = navController, "WatchLater")
        Spacer(modifier = Modifier.weight(1f))
        Row{
            Button(onClick = {
                if (uiState.watchLaterIndex != 0) {
                    viewModel.changeWatchLaterIndex(-1)
                    navController.navigate(MovieCatalogScreen.WatchLater.name)
                }
            }, modifier = Modifier.padding(start = 20.dp)) {
                Text("Previus page")
            }
            Spacer(modifier = Modifier.width(100.dp))
            Button(onClick = {
                viewModel.changeWatchLaterIndex(1)
                navController.navigate(MovieCatalogScreen.WatchLater.name)}) {
                Text("Next page")
            }
        }
        Spacer(modifier = Modifier.height(64.dp))

    }


}