package com.p2ptestexercise.data.authorization

interface AuthorizationRepository {
    suspend fun saveAuthorizationData(authorizationData: AuthorizationData)
    suspend fun getAuthorizationData(): AuthorizationData?
    suspend fun removeAuthorizationData()
}
