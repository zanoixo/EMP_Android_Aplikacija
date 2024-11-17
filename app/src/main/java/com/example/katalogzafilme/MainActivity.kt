package com.example.katalogzafilme

import android.os.Bundle
import android.util.Log
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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.katalogzafilme.ui.theme.KatalogZaFilmeTheme

private const val TAG = "MyActivity"



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "On create called")
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

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }
}


@Composable
fun TopText(title : String){
    Text(
        text = title
    )
}

fun a() {
    Log.d(TAG, "Button pressed")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        for (i in 1..3){
            Row{

                for (j in 1..3) {
                    TextButton(onClick = {a()}) {
                        Text("button$j")
                    }
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