package com.p2ptestexercise.ui.base

interface Presenter<V: View> {
    fun onAttach(view: V)
    fun onDetach()
}
