package com.example.moviecatalog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moviecatalog.MovieCatalogScreen


@Composable
fun TopBar(viewModel: MovieCatologViewModel = viewModel(),
           navController: NavController) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(28.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
    ){
        Button(onClick =  {navController.navigate(MovieCatalogScreen.WatchLater.name) }){

            Text(text = "Watch Later")

        }
        Spacer(modifier = Modifier.width(14.dp))
        Button(onClick =  { navController.navigate(MovieCatalogScreen.Home.name)}){
            Text(text = "Home")
        }
        Spacer(modifier = Modifier.width(14.dp))
        Button(onClick =  { navController.navigate(MovieCatalogScreen.Favorite.name)}){
            Text(text = "Favorite")
        }
    }

}