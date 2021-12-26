package com.p2ptestexercise.ui.main.presenter

import com.p2ptestexercise.interactor.main.MainInteractor
import com.p2ptestexercise.model.ui.Screen
import com.p2ptestexercise.ui.base.BasePresenter
import com.p2ptestexercise.ui.main.view.MainView
import com.p2ptestexercise.util.switchToUI

class MainPresenterImpl(
    private val mainInteractor: MainInteractor
) : BasePresenter<MainView>(), MainPresenter<MainView> {

    override fun onAttach(view: MainView) {
        super.onAttach(view)
        launch {
            val screen = if (mainInteractor.isAuthorized()) Screen.Wallets else Screen.Authorization
            switchToUI { view.routeToScreen(screen) }
        }
    }
}
