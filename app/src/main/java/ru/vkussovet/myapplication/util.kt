package ru.vkussovet.myapplication

import android.content.Context
import android.util.TypedValue
import ru.vkussovet.myapplication.app.VkussovetApp


fun  Int.fromDpToPx(context: Context): Int {
    val metrics = context.resources.displayMetrics

    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        metrics
    ).toInt()
}