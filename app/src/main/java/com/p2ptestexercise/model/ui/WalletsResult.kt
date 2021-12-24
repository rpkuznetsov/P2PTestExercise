package com.p2ptestexercise.model.ui

sealed class WalletsResult {
    data class Success(val wallets: List<WalletUiModel>) : WalletsResult()
    data class Error(val message: String) : WalletsResult()
}
