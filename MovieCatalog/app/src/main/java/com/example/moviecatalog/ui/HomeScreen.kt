package com.example.moviecatalog.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moviecatalog.MovieCatalogScreen
import com.example.moviecatalog.data.availableMovies
import com.example.moviecatalog.ui.MovieCatologViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun HomeScreen(viewModel: MovieCatologViewModel = viewModel(),
               navController: NavController) {

    val uiState = viewModel.uiState.collectAsState().value;

    Column{
        TopBar(viewModel = viewModel, navController = navController)
        Text("Home screen", modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(10.dp))
        for(i in 0..8) {
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                for (j in 0..2) {
                    if (i * 3 + j + uiState.homeIndex * 27 >= availableMovies.count()) {
                        break
                    }
                    Button(onClick = {
                        viewModel.changeMovie(availableMovies[i * 3 + j + uiState.homeIndex * 27])
                        navController.navigate(MovieCatalogScreen.OpenMovie.name)}, modifier = Modifier
                        .width(96.dp)
                        .height(64.dp)) {
                        Text(availableMovies[i * 3 + j + uiState.homeIndex * 27].name)
                    }
                    Spacer(modifier = Modifier
                        .height(70.dp)
                        .width(24.dp))
                }

            }

        }
        Spacer(modifier = Modifier.weight(1f))
        Row{
            Button(onClick = {
                if (uiState.homeIndex != 0) {
                    viewModel.changeHomeIndex(-1)
                    navController.navigate(MovieCatalogScreen.Home.name)
                }
                }, modifier = Modifier.padding(start = 20.dp)) {
                Text("Previus page")
            }
            Spacer(modifier = Modifier.width(100.dp))
            Button(onClick = {
                viewModel.changeHomeIndex(1)
                navController.navigate(MovieCatalogScreen.Home.name)}) {
                Text("Next page")
            }
        }
        Spacer(modifier = Modifier.height(64.dp))



    }


}