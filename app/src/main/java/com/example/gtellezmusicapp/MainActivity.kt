package com.example.gtellezmusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.gtellezmusicapp.screens.DetailScreen
import com.example.gtellezmusicapp.screens.HomeScreen
import com.example.gtellezmusicapp.ui.theme.DetailRoute
import com.example.gtellezmusicapp.ui.theme.GTellezMusicAppTheme
import com.example.gtellezmusicapp.ui.theme.HomeRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GTellezMusicAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = HomeRoute
                    ){
                        composable<HomeRoute> {
                            HomeScreen(navController)
                        }
                        composable<DetailRoute> { backStackEntry ->
                            val args = backStackEntry.toRoute<DetailRoute>()
                            DetailScreen(
                                id = args.id,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GTellezMusicAppTheme {
        Greeting("Android")
    }
}