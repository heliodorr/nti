package ru.vkussovet.myapplication.ui.oredering.menurecyclerview

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vkussovet.myapplication.fromDpToPx

private val EXTRA_LEFT: Int = 500
private val EXTRA_RIGHT: Int = 500

class ExtendedGLM(
    private val context: Context,
    span: Int
): GridLayoutManager(
    context,
    span
) {
    override fun calculateExtraLayoutSpace(state: RecyclerView.State, extraLayoutSpace: IntArray) {
        extraLayoutSpace[0] = EXTRA_LEFT.fromDpToPx(context)
        extraLayoutSpace[1] = EXTRA_RIGHT.fromDpToPx(context)
    }
}