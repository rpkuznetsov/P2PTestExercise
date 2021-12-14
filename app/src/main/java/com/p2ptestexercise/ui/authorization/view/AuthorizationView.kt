package com.p2ptestexercise.ui.authorization.view

interface AuthorizationView {
    fun navigateToNextScreen()
    fun showAuthorizationError()
    fun showLoading(isLoading: Boolean)
}
