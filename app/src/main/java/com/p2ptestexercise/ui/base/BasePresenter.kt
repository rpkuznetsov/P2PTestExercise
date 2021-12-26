package com.p2ptestexercise.ui.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BasePresenter<V: View> : Presenter<V> {

    private val job = SupervisorJob()
    protected var view: V? = null
    protected val scope = CoroutineScope(Dispatchers.IO + job)

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        view = null
        job.cancel()
    }
}
