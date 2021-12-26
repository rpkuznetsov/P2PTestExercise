package com.p2ptestexercise.data.authorization

import android.content.SharedPreferences
import androidx.core.content.edit

class AuthorizationRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : AuthorizationRepository {

    override suspend fun savePublicKey(publicKey: String) =
        sharedPreferences.edit {
            putString(KEY_ACCOUNT_PUBLIC_KEY, publicKey)
            apply()
        }

    override suspend fun getPubicKey(): String? = sharedPreferences.run {
        getString(KEY_ACCOUNT_PUBLIC_KEY, null)
    }

    override suspend fun removePublicKey() = sharedPreferences.edit {
        remove(KEY_ACCOUNT_PUBLIC_KEY)
        apply()
    }
}
