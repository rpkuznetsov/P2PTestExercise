package com.p2ptestexercise.ui.main.presenter

import com.p2ptestexercise.ui.main.view.MainView

interface MainPresenter {
    fun onAttach(view: MainView)
    fun onDetach()
}
