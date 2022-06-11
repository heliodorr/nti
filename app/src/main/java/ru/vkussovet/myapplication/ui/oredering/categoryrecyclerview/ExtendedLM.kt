package ru.vkussovet.myapplication.ui.oredering.categoryrecyclerview

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vkussovet.myapplication.fromDpToPx

private val EXTRA_LEFT: Int = 500
private val EXTRA_RIGHT: Int = 500

class ExtendedLM(
    private val context: Context
): LinearLayoutManager(
    context,
    LinearLayoutManager.HORIZONTAL,
    false
) {

    override fun calculateExtraLayoutSpace(state: RecyclerView.State, extraLayoutSpace: IntArray) {
        extraLayoutSpace[0] = EXTRA_LEFT.fromDpToPx(context)
        extraLayoutSpace[1] = EXTRA_RIGHT.fromDpToPx(context)
    }
}