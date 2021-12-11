package com.p2ptestexercise.di

import com.p2ptestexercise.ui.authorization.interactor.AuthorizationInteractor
import com.p2ptestexercise.ui.authorization.interactor.AuthorizationMvpInteractor
import com.p2ptestexercise.ui.authorization.presenter.AuthorizationMvpPresenter
import com.p2ptestexercise.ui.authorization.presenter.AuthorizationPresenter
import org.koin.dsl.module

val appModule = module {
    single<AuthorizationMvpPresenter> { AuthorizationPresenter() }
    single<AuthorizationMvpInteractor> { AuthorizationInteractor() }
}
