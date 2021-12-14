package com.p2ptestexercise.interactor.authorization

import com.p2ptestexercise.data.authorization.AuthorizationData
import com.p2ptestexercise.data.authorization.AuthorizationRepository
import com.p2ptestexercise.solanaj.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthorizationInteractorImpl(
    private val repository: AuthorizationRepository
) : AuthorizationInteractor {

    override suspend fun authorizeViaSeedPhrase(words: List<String>) = withContext(Dispatchers.IO) {
        val account = Account.fromBip32Mnemonic(words)
        val authorizationData = mapAccountToAuthorisationData(account)
        repository.saveAuthorizationData(authorizationData)
        return@withContext true
    }

    private fun mapAccountToAuthorisationData(account: Account) = AuthorizationData(
        publicKey = account.publicKey.toString(),
        secretKey = account.secretKey.toString()
    )
}
