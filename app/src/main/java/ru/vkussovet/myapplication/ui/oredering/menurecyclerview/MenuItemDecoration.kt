package ru.vkussovet.myapplication.ui.oredering.menurecyclerview

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.vkussovet.myapplication.fromDpToPx

class MenuItemDecoration(
    private val context: Context,
    private val span: Int,
    spaceInDp: Int
): RecyclerView.ItemDecoration() {

    private val space: Int
    private val halfSpace: Int

    init {
        space = spaceInDp.fromDpToPx(context)
        halfSpace = space/2

    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view) + 1
        val isStart = position % span == 1
        val isEnd = position % span == 0

        Log.d("AAA", position.toString())

        outRect.top = halfSpace
        outRect.bottom = halfSpace
        outRect.left = halfSpace
        outRect.right = halfSpace

        if (isStart) {
            outRect.left = space
        }
        if (isEnd){
            outRect.right = space
        }



    }
}