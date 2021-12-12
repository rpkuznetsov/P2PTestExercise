package com.p2ptestexercise.ui.authorization.presenter

import android.text.Editable
import com.p2ptestexercise.ui.authorization.view.AuthorizationView

interface AuthorizationPresenter {
    fun onAuthorizeClick(text: Editable?)
    fun onAttach(view: AuthorizationView)
    fun onDetach()
}
