package com.p2ptestexercise.ui.wallets.presenter

import com.p2ptestexercise.interactor.wallets.WalletsInteractor
import com.p2ptestexercise.ui.wallets.view.WalletsView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class WalletsPresenterImpl(
    private val walletsInteractor: WalletsInteractor
) : WalletsPresenter {

    private var view: WalletsView? = null
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    override fun onAttach(view: WalletsView) {
        this.view = view
    }

    override fun getWallets() {
        scope.launch {
            view?.showLoading(true)
            val wallets = walletsInteractor.getWallets()
            view?.showLoading(false)
            view?.renderWallets(wallets)
        }
    }

    override fun onDetach() {
        view = null
        job.cancel()
    }
}
