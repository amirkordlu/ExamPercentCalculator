package com.amk.haseb.ui.features.resultScreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.amk.haseb.R
import com.amk.haseb.ui.theme.HasebTheme
import com.amk.haseb.ui.theme.Typography
import com.amk.haseb.util.AnimatedCounter
import com.amk.haseb.util.appendTextDialog
import com.maxkeppeker.sheets.core.CoreDialog
import com.maxkeppeker.sheets.core.models.CoreSelection
import com.maxkeppeker.sheets.core.models.base.ButtonStyle
import com.maxkeppeker.sheets.core.models.base.Header
import com.maxkeppeker.sheets.core.models.base.IconSource
import com.maxkeppeker.sheets.core.models.base.SelectionButton
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import dev.burnoo.cokoin.navigation.getNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    HasebTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ResultScreen("", "")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ResultScreen(arg1: String, arg2: String) {
    val coroutineScope = rememberCoroutineScope()
    val navigation = getNavController()
    val infoDialogState = rememberUseCaseState()
    val context = LocalContext.current

    var resultWithFalse by remember { mutableStateOf(0.0f) }
    var resultWithoutFalse by remember { mutableStateOf(0.0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        MainToolbar(
            onBackClicked = { navigation.popBackStack() },
            onInfoClicked = {
                infoDialogState.show()
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 72.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MainAnimation()
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = ":درصد(نمره خام)",
                style = Typography.bodyMedium
            )
            AnimatedCounter(count = resultWithFalse, style = Typography.bodyLarge)

            Spacer(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))

            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = ":اگه سوالات غلط رو نزده رها میکردی",
                style = Typography.bodyMedium,
            )
            AnimatedCounter(count = resultWithoutFalse, style = Typography.bodyLarge)
            coroutineScope.launch {
                delay(150)
                resultWithFalse = arg1.toFloat()
            }

            coroutineScope.launch {
                delay(300)
                resultWithoutFalse = arg2.toFloat()
            }
        }
    }

    CoreDialog(
        state = infoDialogState,
        selection = CoreSelection(
            withButtonView = false,
        ),
        header = Header.Custom {
            Text(
                text = "Info",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.dana_medium)),
                fontWeight = FontWeight(800),
                fontSize = 22.sp
            )
        },
        onPositiveValid = true,
        body = {
            Text(
                text = "",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.dana_medium)),
                fontSize = 16.sp
            )
        }
    )
}

@Composable
fun MainAnimation() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.one)
    )

    LottieAnimation(
        modifier = Modifier
            .size(270.dp)
            .padding(top = 16.dp, bottom = 36.dp),
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}

@Composable
fun MainToolbar(onBackClicked: () -> Unit, onInfoClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = { onBackClicked.invoke() }) {
            Image(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(40.dp)
            )
        }

        Text(text = "نتیجه آزمون", fontSize = 22.sp, style = Typography.bodyMedium)

        IconButton(onClick = { onInfoClicked.invoke() }) {
            Image(
                imageVector = Icons.Default.Info,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(40.dp)
            )
        }
    }

}