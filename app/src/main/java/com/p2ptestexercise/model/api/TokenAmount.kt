package com.p2ptestexercise.model.api

data class TokenAmount(
    val amount: String,
    val decimals: Int,
    val uiAmount: Double,
    val uiAmountString: String
)
