package com.p2ptestexercise.ui.authorization.presenter

import android.text.Editable
import com.p2ptestexercise.R
import com.p2ptestexercise.interactor.authorization.AuthorizationInteractor
import com.p2ptestexercise.ui.authorization.view.AuthorizationView
import com.p2ptestexercise.ui.base.BasePresenter
import com.p2ptestexercise.util.StringService
import com.p2ptestexercise.util.switchToUI
import kotlinx.coroutines.launch

class AuthorizationPresenterImp(
    private val authorizationInteractor: AuthorizationInteractor,
    private val stringService: StringService
) : BasePresenter<AuthorizationView>(), AuthorizationPresenter<AuthorizationView> {

    override fun onAuthorizeClick(seedPhrase: Editable?) {
        if (seedPhrase.isNullOrBlank()) {
            view?.showError(stringService.getString(R.string.empty_seed_phrase_error_message))
            return
        }

        scope.launch {
            switchToUI { view?.showLoading(true) }
            val words = seedPhrase?.toString()?.split(' ') ?: listOf()
            val success = authorizationInteractor.authorizeViaSeedPhrase(words)
            switchToUI {
                view?.showLoading(false)
                if (success) view?.navigateToNextScreen()
                else view?.showError(stringService.getString(R.string.authorization_error_message))
            }
        }
    }
}
