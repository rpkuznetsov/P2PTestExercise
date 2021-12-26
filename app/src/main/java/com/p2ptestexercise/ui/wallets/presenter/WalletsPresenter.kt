package com.p2ptestexercise.ui.wallets.presenter

import com.p2ptestexercise.ui.base.Presenter
import com.p2ptestexercise.ui.base.View

interface WalletsPresenter<V : View> : Presenter<V> {
    fun updateWallets()
    fun onLogOutClick(): Boolean
}
