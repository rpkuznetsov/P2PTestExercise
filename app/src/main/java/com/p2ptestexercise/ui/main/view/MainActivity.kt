package com.p2ptestexercise.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.p2ptestexercise.R
import com.p2ptestexercise.model.ui.Screen
import com.p2ptestexercise.ui.authorization.view.AuthorizationFragment
import com.p2ptestexercise.ui.main.presenter.MainPresenter
import com.p2ptestexercise.ui.wallets.view.WalletsFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(R.layout.activity_main), MainView {

    private val presenter by inject<MainPresenter<MainView>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun routeToScreen(screen: Screen) = when (screen) {
        Screen.Authorization -> supportFragmentManager.commit {
            replace(R.id.fragment_container_view, AuthorizationFragment())
        }

        Screen.Wallets -> supportFragmentManager.commit {
            replace(R.id.fragment_container_view, WalletsFragment())
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
