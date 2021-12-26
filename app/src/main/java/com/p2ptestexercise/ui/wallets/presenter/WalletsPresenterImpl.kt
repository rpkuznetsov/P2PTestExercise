package com.p2ptestexercise.ui.wallets.presenter

import com.p2ptestexercise.R
import com.p2ptestexercise.interactor.wallets.WalletsInteractor
import com.p2ptestexercise.model.ui.WalletsResult
import com.p2ptestexercise.ui.base.BasePresenter
import com.p2ptestexercise.ui.wallets.view.WalletsView
import com.p2ptestexercise.util.StringService
import com.p2ptestexercise.util.switchToUI
import kotlinx.coroutines.launch

class WalletsPresenterImpl(
    private val walletsInteractor: WalletsInteractor,
    private val stringService: StringService
) : BasePresenter<WalletsView>(), WalletsPresenter<WalletsView> {

    override fun updateWallets() {
        scope.launch {
            try {
                switchToUI { view?.showLoading(true) }
                val walletsResult = walletsInteractor.getWallets()
                switchToUI {
                    view?.showLoading(false)
                    when (walletsResult) {
                        is WalletsResult.Success -> view?.renderWallets(walletsResult.wallets)
                        is WalletsResult.Error -> view?.showError(walletsResult.message)
                    }
                }
            } catch (e: Exception) {
                switchToUI {
                    view?.showLoading(false)
                    view?.showError(stringService.getString(R.string.default_error_message))
                }
            }
        }
    }

    override fun onLogOutClick(): Boolean {
        scope.launch {
            walletsInteractor.logOut()
            switchToUI {
                view?.routeToAuthorization()
            }
        }

        return true
    }
}
