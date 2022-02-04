package com.ralphevmanzano.workoutsforhumans.common.extensions

import android.widget.ImageView
import androidx.core.content.ContextCompat

fun ImageView.setImageDrawableFromString(strRes: String) {
    val resId = context.resources.getIdentifier(strRes, "drawable", context.packageName)
    setImageDrawable(ContextCompat.getDrawable(context, resId))
}