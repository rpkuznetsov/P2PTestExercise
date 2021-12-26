package com.p2ptestexercise.data.authorization

interface AuthorizationRepository {
    suspend fun savePublicKey(publicKey: String)
    suspend fun getPubicKey(): String?
    suspend fun removePublicKey()
}
