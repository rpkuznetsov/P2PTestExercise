package com.p2ptestexercise.model.api

data class Info(
    val `delegate`: String,
    val delegatedAmount: DelegatedAmount,
    val isNative: Boolean,
    val mint: String,
    val owner: String,
    val state: String,
    val tokenAmount: TokenAmount
)
