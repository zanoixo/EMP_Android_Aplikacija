package com.example.moviecatalog.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun TopBar(viewModel: MovieCatologViewModel = viewModel(),
           navController: NavController) {
    Text(
        text = " for Steps",
        fontSize = 24.sp,
    )
}