package com.p2ptestexercise.ui.authorization.presenter

import android.text.Editable
import com.p2ptestexercise.ui.base.Presenter
import com.p2ptestexercise.ui.base.View

interface AuthorizationPresenter<V: View> : Presenter<V> {
    fun onAuthorizeClick(seedPhrase: Editable?)
}
