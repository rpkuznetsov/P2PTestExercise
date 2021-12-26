package com.p2ptestexercise.interactor.authorization

import com.p2ptestexercise.data.authorization.AuthorizationRepository
import com.p2ptestexercise.solanaj.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthorizationInteractorImpl(
    private val repository: AuthorizationRepository
) : AuthorizationInteractor {

    override suspend fun authorizeViaSeedPhrase(words: List<String>) = withContext(Dispatchers.IO) {
        val account = Account.fromBip32Mnemonic(words)
        val publicKey = account.publicKey.toString()
        repository.savePublicKey(publicKey)
        return@withContext true
    }
}
