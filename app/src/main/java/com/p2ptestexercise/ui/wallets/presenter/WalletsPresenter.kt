package com.p2ptestexercise.ui.wallets.presenter

import com.p2ptestexercise.ui.wallets.view.WalletsView

interface WalletsPresenter {
    fun onAttach(view: WalletsView)
    fun updateWallets()
    fun onDetach()
}
