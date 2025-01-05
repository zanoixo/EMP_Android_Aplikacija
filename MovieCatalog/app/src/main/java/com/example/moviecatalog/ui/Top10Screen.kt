package com.example.moviecatalog.ui

import android.util.Log
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moviecatalog.MovieCatalogScreen
import com.example.moviecatalog.data.availableMovies


@Composable
fun Top10Screen(viewModel: MovieCatalogViewModel = viewModel(),
                   navController: NavController) {
    val uiState = viewModel.uiState.collectAsState().value;
    Column(Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(50.dp))
        Text("Top 10 screen", modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(10.dp))
        Log.i("API", "" + uiState.success)
        if (uiState.success == 1) {
            for (i in 0..9) {
                Text("" + (i + 1) + ": " + uiState.topList[i].title, modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(10.dp))
            }
        }else {
            Text("Couldnt get the top 10 list", modifier = Modifier.align(Alignment.CenterHorizontally))
        }

        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {navController.navigate(MovieCatalogScreen.Home.name)}, modifier = Modifier.padding(start = 20.dp).padding(bottom = 20.dp)) {
            Text("Back")
        }


    }


}