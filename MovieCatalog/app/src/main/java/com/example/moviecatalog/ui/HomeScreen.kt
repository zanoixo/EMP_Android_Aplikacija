package com.example.moviecatalog.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moviecatalog.ui.MovieCatologViewModel

@Composable
fun HomeScreen(viewModel: MovieCatologViewModel = viewModel(),
               navController: NavController) {

    TopBar(viewModel = viewModel, navController = navController)
}