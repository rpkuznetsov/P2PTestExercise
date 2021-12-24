package com.p2ptestexercise.util

import android.content.Context
import androidx.annotation.StringRes

class StringService(private val context: Context) {

    fun getString(@StringRes resId: Int, vararg formatArgs: Any) =
        context.getString(resId, *formatArgs)
}
