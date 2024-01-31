package com.amk.haseb.util

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
