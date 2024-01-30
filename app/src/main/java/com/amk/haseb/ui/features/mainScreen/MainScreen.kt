package com.amk.haseb.ui.features.mainScreen

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.amk.haseb.ui.theme.HasebTheme

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    HasebTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            MainScreen()
        }
    }
}


@Composable
fun MainScreen() {

}