package com.p2ptestexercise.model.ui

sealed class Screen {
    object Authorization : Screen()
    object Wallets : Screen()
}
