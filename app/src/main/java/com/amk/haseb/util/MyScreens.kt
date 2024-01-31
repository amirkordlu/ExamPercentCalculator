package com.amk.haseb.util

sealed class MyScreens(val route: String) {
    object MainScreen : MyScreens("mainScreen")
    object ResultScreen : MyScreens("resultScreen")

}
