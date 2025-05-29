package com.plcoding.dictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.dictionary.ui.components.DelivererScreen
import com.plcoding.dictionary.ui.components.DictionaryScreen
import com.plcoding.dictionary.ui.theme.DictionaryTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DictionaryTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "dictionary") {
                    composable("dictionary") {
                       // DictionaryScreen()
                        DelivererScreen()
                    }
                    // Add more destinations here
                }
            }
        }

    }
}