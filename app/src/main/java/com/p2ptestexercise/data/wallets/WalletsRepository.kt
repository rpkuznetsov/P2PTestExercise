package com.p2ptestexercise.data.wallets

import com.p2ptestexercise.data.authorization.AuthorizationData
import com.p2ptestexercise.model.api.WalletsResponse

interface WalletsRepository {
    suspend fun fetchWallets(authorizationData: AuthorizationData): WalletsResponse
}
