package com.example.katalogzafilme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.katalogzafilme.ui.theme.KatalogZaFilmeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KatalogZaFilmeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    TopText("Katalog filmov")
                }
            }

        }
    }
}

@Composable
fun TopText(title : String){
    Text(
        text = title
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        for (i in 1..3){
            Row{

                for (j in 1..3) {
                    Text(
                        text = "$i box ",
                        modifier = modifier
                    )
                }



            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KatalogZaFilmeTheme {
        Greeting("Android")

    }
}