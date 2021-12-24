package com.p2ptestexercise.model.api

data class WalletsRequest(
    val id: String,
    val jsonrpc: String,
    val method: String,
    val params: List<Any>
)
