package com.p2ptestexercise.data.authorization

import android.content.SharedPreferences
import androidx.core.content.edit

class AuthorizationRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : AuthorizationRepository {

    override suspend fun saveAuthorizationData(authorizationData: AuthorizationData) =
        sharedPreferences.edit {
            putString(KEY_ACCOUNT_PUBLIC_KEY, authorizationData.publicKey)
            putString(KEY_ACCOUNT_SECRET_KEY, authorizationData.secretKey)
            apply()
        }

    override suspend fun getAuthorizationData(): AuthorizationData? = sharedPreferences.run {
        val publicKey = getString(KEY_ACCOUNT_PUBLIC_KEY, null) ?: return null
        val secretKey = getString(KEY_ACCOUNT_SECRET_KEY, null) ?: return null
        AuthorizationData(publicKey, secretKey)
    }

    override suspend fun removeAuthorizationData() = sharedPreferences.edit {
        remove(KEY_ACCOUNT_PUBLIC_KEY)
        remove(KEY_ACCOUNT_SECRET_KEY)
        apply()
    }
}
