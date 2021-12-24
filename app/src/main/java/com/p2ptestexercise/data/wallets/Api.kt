package com.p2ptestexercise.data.wallets

import com.p2ptestexercise.model.api.WalletsRequest
import com.p2ptestexercise.model.api.WalletsResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("/")
    suspend fun getTokenAccountsByOwner(@Body body: WalletsRequest): WalletsResponse
}
