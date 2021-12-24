package com.p2ptestexercise.interactor.main

import com.p2ptestexercise.data.authorization.AuthorizationRepository

class MainInteractorImpl(
    private val authorizationRepository: AuthorizationRepository
) : MainInteractor {

    override suspend fun isAuthorized() =
        authorizationRepository.getAuthorizationData() != null
}
