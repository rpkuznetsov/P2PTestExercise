package com.p2ptestexercise.ui.authorization.presenter

import android.text.Editable
import com.p2ptestexercise.R
import com.p2ptestexercise.interactor.authorization.AuthorizationInteractor
import com.p2ptestexercise.ui.authorization.view.AuthorizationView
import com.p2ptestexercise.ui.base.BasePresenter
import com.p2ptestexercise.util.StringService
import com.p2ptestexercise.util.switchToUI
import kotlinx.coroutines.*

class AuthorizationPresenterImp(
    private val authorizationInteractor: AuthorizationInteractor,
    private val stringService: StringService
) : BasePresenter<AuthorizationView>(), AuthorizationPresenter<AuthorizationView> {

    override fun onAuthorizeClick(text: Editable?) {
        scope.launch {
            switchToUI { view?.showLoading(true) }
            val words = text?.toString()?.split(' ') ?: listOf()
            val success = authorizationInteractor.authorizeViaSeedPhrase(words)
            switchToUI {
                view?.showLoading(false)
                if (success) view?.navigateToNextScreen()
                else view?.showAuthorizationError(stringService.getString(R.string.authorization_error_message))
            }
        }
    }
}
