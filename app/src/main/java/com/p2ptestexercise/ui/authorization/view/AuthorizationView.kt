package com.p2ptestexercise.ui.authorization.view

import com.p2ptestexercise.ui.base.View

interface AuthorizationView : View {
    fun navigateToNextScreen()
    fun showError(message: String)
    fun showLoading(isLoading: Boolean)
}
