package com.p2ptestexercise.ui.wallets.view

import com.p2ptestexercise.model.ui.WalletUiModel
import com.p2ptestexercise.ui.base.View

interface WalletsView : View {
    fun showLoading(isLoading: Boolean)
    fun showError(message: String)
    fun renderWallets(wallets: List<WalletUiModel>)
    fun routeToAuthorization()
}
