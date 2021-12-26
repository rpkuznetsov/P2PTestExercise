package com.p2ptestexercise.interactor.wallets

import com.p2ptestexercise.model.ui.WalletsResult

interface WalletsInteractor {
    suspend fun getWallets(): WalletsResult
    suspend fun logOut()
}
