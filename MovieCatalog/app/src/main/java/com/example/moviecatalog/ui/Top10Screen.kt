package com.example.moviecatalog.ui

import androidx.compose.foundation.layout.Column

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


@Composable
fun Top10Screen(viewModel: MovieCatologViewModel = viewModel(),
                   navController: NavController) {
    val uiState = viewModel.uiState.collectAsState().value;
    Column {
        for (i in 0..9) {
            Text("" + (i + 1) + ": " + uiState.topList[i].title, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }


}