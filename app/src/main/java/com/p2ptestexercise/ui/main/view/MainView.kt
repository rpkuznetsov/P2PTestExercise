package com.p2ptestexercise.ui.main.view

import com.p2ptestexercise.model.ui.Screen
import com.p2ptestexercise.ui.base.View

interface MainView : View {
    fun routeToScreen(screen: Screen)
}
