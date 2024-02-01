package com.amk.haseb.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.amk.haseb.R

fun calculateScore(trueValue: Int, falseValue: Int, noneValue: Int): Pair<String, String> {
    val totalQuestions = trueValue + falseValue + noneValue

    // Percentage with false
    val percentageWithFalse = ((trueValue * 3 - falseValue).toFloat() / (totalQuestions * 3)) * 100
    val formattedPercentageWithFalse = String.format("%.1f", percentageWithFalse)

    // Percentage without false
    val percentageWithoutFalse = (trueValue.toFloat() / totalQuestions) * 100
    val formattedPercentageWithoutFalse = String.format("%.1f", percentageWithoutFalse)

    return Pair(formattedPercentageWithFalse, formattedPercentageWithoutFalse)
}

const val KEY1_ARG = "Key1"
const val KEY2_ARG = "Key2"

fun appendTextDialog(text: String): AnnotatedString {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontFamily = FontFamily(Font(R.font.dana_medium)),
                fontSize = 14.sp
            )
        ) {
            append(text)
        }
    }
    return annotatedString
}
