package com.p2ptestexercise.data.authorization

import android.content.SharedPreferences

class AuthorizationRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : AuthorizationRepository {

    override suspend fun saveAuthorizationData(authorizationData: AuthorizationData) {
        sharedPreferences.edit().apply {
            putString(KEY_ACCOUNT_PUBLIC_KEY, authorizationData.publicKey)
            putString(KEY_ACCOUNT_SECRET_KEY, authorizationData.secretKey)
            apply()
        }
    }

    override suspend fun getAuthorizationData(): AuthorizationData {
        val publicKey = sharedPreferences.getString(KEY_ACCOUNT_PUBLIC_KEY, "") ?: ""
        val secretKey = sharedPreferences.getString(KEY_ACCOUNT_SECRET_KEY, "") ?: ""
        return AuthorizationData(publicKey, secretKey)
    }
}
