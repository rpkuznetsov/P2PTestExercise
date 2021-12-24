package com.p2ptestexercise.model.api

data class WalletsResponse(
    val id: String,
    val jsonrpc: String,
    val result: Result? = null,
    val error: Error? = null
)
