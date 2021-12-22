package com.p2ptestexercise.data.wallets

import retrofit2.http.GET

interface Api {
    @GET("getTokenAccountsByOwner")
    fun getTokenAccountsByOwner(publicKey: String)
}
