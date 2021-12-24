package com.p2ptestexercise.interactor.wallets

import com.p2ptestexercise.model.ui.WalletUiModel

interface WalletsInteractor {
    suspend fun getWallets(): List<WalletUiModel>
}
