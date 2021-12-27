package com.p2ptestexercise.ui.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

open class BasePresenter<V : View> : Presenter<V> {

    private val job = SupervisorJob()
    protected var view: V? = null

    override fun onAttach(view: V) {
        this.view = view
    }

    protected fun launch(block: suspend CoroutineScope.() -> Unit) =
        CoroutineScope(Dispatchers.IO + job).launch { block() }

    override fun onDetach() {
        view = null
        job.cancel()
    }
}
