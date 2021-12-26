package com.p2ptestexercise.ui.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

open class BasePresenter<V : View> : Presenter<V> {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    protected var view: V? = null

    override fun onAttach(view: V) {
        this.view = view
    }

    protected fun launch(block: suspend CoroutineScope.() -> Unit) = scope.launch { block() }

    override fun onDetach() {
        view = null
        job.cancel()
    }
}
