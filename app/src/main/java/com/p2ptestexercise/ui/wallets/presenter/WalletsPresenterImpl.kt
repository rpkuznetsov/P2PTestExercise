package com.p2ptestexercise.ui.wallets.presenter

import com.p2ptestexercise.interactor.wallets.WalletsInteractor
import com.p2ptestexercise.ui.wallets.view.WalletsView
import com.p2ptestexercise.util.switchToUI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class WalletsPresenterImpl(
    private val walletsInteractor: WalletsInteractor
) : WalletsPresenter {

    private var view: WalletsView? = null
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    override fun onAttach(view: WalletsView) {
        this.view = view
        fetchWallets()
    }

    override fun updateWallets() {
        scope.launch {
            switchToUI { view?.showRefreshing(true) }
            val wallets = walletsInteractor.getWallets()
            switchToUI {
                view?.showRefreshing(false)
                view?.renderWallets(wallets)
            }
        }
    }

    private fun fetchWallets() {
        scope.launch {
            switchToUI { view?.showLoading(true) }
            val wallets = walletsInteractor.getWallets()
            switchToUI {
                view?.showLoading(false)
                view?.renderWallets(wallets)
            }
        }
    }

    override fun onDetach() {
        view = null
        job.cancel()
    }
}
