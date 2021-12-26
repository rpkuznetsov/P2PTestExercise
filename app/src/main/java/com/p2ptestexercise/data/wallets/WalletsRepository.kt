package com.p2ptestexercise.data.wallets

import com.p2ptestexercise.model.api.WalletsResponse

interface WalletsRepository {
    suspend fun fetchWallets(publicKey: String): WalletsResponse
}
