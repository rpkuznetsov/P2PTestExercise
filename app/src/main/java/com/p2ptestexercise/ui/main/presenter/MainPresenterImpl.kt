package com.p2ptestexercise.ui.main.presenter

import com.p2ptestexercise.interactor.main.MainInteractor
import com.p2ptestexercise.model.ui.Screen
import com.p2ptestexercise.ui.main.view.MainView
import com.p2ptestexercise.util.switchToUI
import kotlinx.coroutines.*

class MainPresenterImpl(
    private val mainInteractor: MainInteractor
) : MainPresenter {

    private var view: MainView? = null
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    override fun onAttach(view: MainView) {
        this.view = view
        scope.launch {
            val screen = if (mainInteractor.isAuthorized()) Screen.Wallets else Screen.Authorization
            switchToUI { view.routeToScreen(screen) }
        }
    }

    override fun onDetach() {
        view = null
        job.cancel()
    }
}
