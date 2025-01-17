package com.p2ptestexercise.data.wallets

import com.p2ptestexercise.model.api.WalletsRequest
import com.p2ptestexercise.model.api.WalletsResponse
import java.util.*

class WalletsRepositoryImpl(
    private val api: Api
) : WalletsRepository {

    override suspend fun fetchWallets(publicKey: String): WalletsResponse {
        val body = WalletsRequest(
            id = UUID.randomUUID().toString(),
            jsonrpc = JSON_RPC,
            method = METHOD,
            params = listOf(
                publicKey,
                mapOf(PROGRAM_ID to PROGRAM_ID_VALUE),
                mapOf(ENCODING to JSON_PARSED)
            )
        )
        return api.getTokenAccountsByOwner(body)
    }

    companion object {
        private const val JSON_RPC = "2.0"
        private const val METHOD = "getTokenAccountsByOwner"
        private const val PROGRAM_ID = "programId"
        private const val ENCODING = "encoding"
        private const val JSON_PARSED = "jsonParsed"
        private const val PROGRAM_ID_VALUE = "TokenkegQfeZyiNwAJbNbGKPFXCWuBvf9Ss623VQ5DA"
    }
}
