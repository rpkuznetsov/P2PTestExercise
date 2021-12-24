package com.p2ptestexercise.ui.wallets.view

import com.p2ptestexercise.model.ui.WalletUiModel

interface WalletsView {
    fun showLoading(isLoading: Boolean)
    fun renderWallets(wallets: List<WalletUiModel>)
}
