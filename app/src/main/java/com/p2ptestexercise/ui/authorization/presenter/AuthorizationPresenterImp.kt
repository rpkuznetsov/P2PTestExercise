package com.p2ptestexercise.ui.authorization.presenter

import android.text.Editable
import com.p2ptestexercise.interactor.authorization.AuthorizationInteractor
import com.p2ptestexercise.ui.authorization.view.AuthorizationView
import kotlinx.coroutines.*

class AuthorizationPresenterImp(
    private val authorizationInteractor: AuthorizationInteractor
) : AuthorizationPresenter {

    private var view: AuthorizationView? = null
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    override fun onAttach(view: AuthorizationView) {
        this.view = view
    }

    override fun onAuthorizeClick(text: Editable?) {
        scope.launch {
            val words = text?.toString()?.split(' ') ?: listOf()
            val success = authorizationInteractor.authorizeViaSeedPhrase(words)
            if (success) view?.navigateToNextScreen()
            else view?.showAuthorizationError()
        }
    }

    override fun onDetach() {
        view = null
        job.cancel()
    }
}
