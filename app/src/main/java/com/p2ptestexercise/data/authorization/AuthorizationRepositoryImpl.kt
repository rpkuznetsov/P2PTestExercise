package com.p2ptestexercise.data.authorization

import android.content.SharedPreferences

class AuthorizationRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : AuthorizationRepository {

    override fun saveAuthorizationData(authorizationData: AuthorizationData) {
        sharedPreferences.edit().apply {
            putString(KEY_ACCOUNT_PUBLIC_KEY, authorizationData.publicKey)
            putString(KEY_ACCOUNT_SECRET_KEY, authorizationData.secretKey)
            apply()
        }
    }
}
