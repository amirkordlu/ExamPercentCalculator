package com.amk.haseb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amk.haseb.ui.features.mainScreen.MainScreen
import com.amk.haseb.ui.theme.HasebTheme
import com.amk.haseb.util.MyScreens
import dev.burnoo.cokoin.navigation.KoinNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HasebTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HasebUI()
                }
            }
        }
    }
}

@Composable
fun HasebUI() {
    val navController = rememberNavController()
    KoinNavHost(
        navController = navController,
        startDestination = MyScreens.MainScreen.route
    ) {

        composable(MyScreens.MainScreen.route) {
            MainScreen()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HasebTheme {
        HasebUI()
    }
}