package com.example.MovieCatalog.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun WatchLaterScreen(viewModel: MovieCatologViewModel = viewModel(),
                     navController: NavController) {
    val uiState = viewModel.uiState.collectAsState().value;

}