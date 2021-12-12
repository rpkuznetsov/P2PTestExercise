package com.p2ptestexercise.interactor.authorization

interface AuthorizationInteractor {
    suspend fun authorizeViaSeedPhrase(words: List<String>): Boolean
}
