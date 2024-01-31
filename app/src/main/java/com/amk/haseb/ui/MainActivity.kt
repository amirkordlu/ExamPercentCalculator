package com.amk.haseb.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.amk.haseb.ui.features.mainScreen.MainScreen
import com.amk.haseb.ui.features.resultScreen.ResultScreen
import com.amk.haseb.ui.theme.HasebTheme
import com.amk.haseb.util.KEY1_ARG
import com.amk.haseb.util.KEY2_ARG
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

        composable(
            route = MyScreens.ResultScreen.route + "/" + "{$KEY1_ARG}" + "/" + "{$KEY2_ARG}",
            arguments = listOf(
                navArgument(KEY1_ARG) { type = NavType.StringType },
                navArgument(KEY2_ARG) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val arg1 = backStackEntry.arguments?.getString(KEY1_ARG) ?: ""
            val arg2 = backStackEntry.arguments?.getString(KEY2_ARG) ?: ""
            ResultScreen(arg1, arg2)
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