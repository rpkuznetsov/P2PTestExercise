package com.p2ptestexercise.data.authorization

interface AuthorizationRepository {
    fun saveAuthorizationData(authorizationData: AuthorizationData)
}
