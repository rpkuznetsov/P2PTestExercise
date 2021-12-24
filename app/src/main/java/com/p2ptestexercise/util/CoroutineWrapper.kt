package com.p2ptestexercise.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> switchToUI(block: CoroutineScope.() -> T) =
    withContext(Dispatchers.Main) { block() }
