package com.amk.haseb.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp
import com.amk.haseb.R

val Typography = Typography(
    bodyLarge = TextStyle(
        fontSize = 38.sp,
        fontFamily = FontFamily(Font(R.font.dana_medium)),
        fontWeight = FontWeight(400),
        color = Color(0xFF424242),
        textAlign = TextAlign.Center,
    ),

    bodyMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.dana_medium)),
        fontWeight = FontWeight(400),
        color = Color(0xFF424242),
        textAlign = TextAlign.Center,
    ),

    bodySmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.dana_medium)),
        fontWeight = FontWeight(400),
        color = Color(0xFF424242),
        textAlign = TextAlign.Center,
    )

)

val textFieldStyle = TextStyle(
    fontSize = 14.sp,
    fontFamily = FontFamily(Font(R.font.dana_medium)),
    fontWeight = FontWeight(400),
    color = Color(0xFF424242),
    textAlign = TextAlign.Center
)