package de.check24.devtest.ui.widget

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    context: Context,
    @DimenRes verticalMarginRes: Int? = null,
    @DimenRes horizontalMarginRes: Int? = null
) :
    RecyclerView.ItemDecoration() {

    private val verticalMargin =
        if (verticalMarginRes == null || verticalMarginRes == 0) 0
        else context.resources.getDimensionPixelSize(verticalMarginRes)
    private val horizontalMargin =
        if (horizontalMarginRes == null || horizontalMarginRes == 0) 0
        else context.resources.getDimensionPixelSize(horizontalMarginRes)


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = verticalMargin
        outRect.left = horizontalMargin
        outRect.right = horizontalMargin
        // Do not add top margin only to the first item.
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = verticalMargin
        }
    }
}