package com.p2ptestexercise.model.api

data class Account(
    val `data`: Data,
    val executable: Boolean,
    val lamports: Int,
    val owner: String,
    val rentEpoch: Int
)
