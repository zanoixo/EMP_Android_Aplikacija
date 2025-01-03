package com.example.moviecatalog

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviecatalog.ui.FavoriteScreen
import com.example.moviecatalog.ui.WatchLaterScreen
import com.example.moviecatalog.ui.HomeScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.moviecatalog.data.Movie
import com.example.moviecatalog.ui.MovieCatologViewModel
import com.example.moviecatalog.ui.OpenMovieScreen

enum class MovieCatalogScreen() {
    Home,
    Favorite,
    WatchLater,
    OpenMovie,
}

@Composable
fun MovieCatalogApp(viewModel: MovieCatologViewModel = viewModel(),
                   navController: NavHostController = rememberNavController()) {
    viewModel.setTop10()
    NavHost(navController = navController,
        startDestination = MovieCatalogScreen.Home.name
    ) {
        composable(route = MovieCatalogScreen.Home.name) {
            HomeScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = MovieCatalogScreen.WatchLater.name) {
            WatchLaterScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = MovieCatalogScreen.Favorite.name) {
            FavoriteScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = MovieCatalogScreen.OpenMovie.name) {
            OpenMovieScreen(viewModel = viewModel, navController = navController)
        }
    }
}