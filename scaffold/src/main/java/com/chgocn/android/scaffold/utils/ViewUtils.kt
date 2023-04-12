package com.chgocn.android.scaffold.utils

import android.graphics.Rect
import android.view.TouchDelegate
import android.view.View

object ViewUtils {

    /**
     * 扩大 View 的点击范围
     * @param view 需要扩大点击范围的 View
     * @param additionalTouchArea 需要扩大的点击范围大小
     */
    fun expandViewTouchArea(view: View, additionalTouchArea: Int) {
        val parent = view.parent as View
        parent.post {
            val rect = Rect()
            view.getHitRect(rect)

            rect.top -= additionalTouchArea
            rect.left -= additionalTouchArea
            rect.bottom += additionalTouchArea
            rect.right += additionalTouchArea

            parent.touchDelegate = TouchDelegate(rect, view)
        }
    }
}
