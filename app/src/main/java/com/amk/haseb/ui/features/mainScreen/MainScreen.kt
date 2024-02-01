package com.amk.haseb.ui.features.mainScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amk.haseb.R
import com.amk.haseb.ui.theme.HasebTheme
import com.amk.haseb.ui.theme.Typography
import com.amk.haseb.ui.theme.textFieldStyle
import com.amk.haseb.util.MyScreens
import com.amk.haseb.util.calculateScore
import dev.burnoo.cokoin.navigation.getNavController

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
    var trueValue by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    val navigation = getNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 28.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(300.dp),
            painter = painterResource(id = R.drawable.img_main),
            contentDescription = null
        )


        val trueValue = mainTextField("تعداد پاسخ صحیح")
        val falseValue = mainTextField("تعداد پاسخ غلط")
        val noneValue = lastTextField("تعداد سوالات نزده")


        Button(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .padding(top = 8.dp, bottom = 16.dp)
                .height(56.dp),
            onClick = {
                if (trueValue.isEmpty() || falseValue.isEmpty() || noneValue.isEmpty()) {
                    Toast.makeText(context, "چیزی رو خالی نذار :)", Toast.LENGTH_SHORT).show()
                } else {
                    val percentage =
                        calculateScore(trueValue.toInt(), falseValue.toInt(), noneValue.toInt())
                    navigation.navigate("${MyScreens.ResultScreen.route}/${percentage.first}/${percentage.second}")

                }
            },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF7E84F9))
        ) {
            Text(
                text = "محاسبه درصد",
                style = Typography.bodyMedium,
                color = Color.White
            )

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainTextField(hint: String): String {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(0.75f),
        value = text,
        onValueChange = { text = it },
        textStyle = textFieldStyle,
        placeholder = {
            Text(
                text = hint,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = textFieldStyle
            )
        },
        shape = RoundedCornerShape(14.dp),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal,
            imeAction = ImeAction.Next
        ),
    )
    return text.text
}

@Composable
fun lastTextField(hint: String): String {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(0.75f),
        value = text,
        onValueChange = { text = it },
        textStyle = textFieldStyle,
        placeholder = {
            Text(
                text = hint,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = textFieldStyle
            )
        },
        shape = RoundedCornerShape(14.dp),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal,
            imeAction = ImeAction.Done
        ),
    )
    return text.text
}
