package com.p2ptestexercise.di

import android.content.Context
import android.content.SharedPreferences
import com.p2ptestexercise.data.authorization.AuthorizationRepository
import com.p2ptestexercise.data.authorization.AuthorizationRepositoryImpl
import com.p2ptestexercise.data.authorization.PREFERENCES_FILE_KEY
import com.p2ptestexercise.data.wallets.WalletsRepository
import com.p2ptestexercise.data.wallets.WalletsRepositoryImpl
import com.p2ptestexercise.interactor.authorization.AuthorizationInteractorImpl
import com.p2ptestexercise.interactor.authorization.AuthorizationInteractor
import com.p2ptestexercise.interactor.main.MainInteractor
import com.p2ptestexercise.interactor.main.MainInteractorImpl
import com.p2ptestexercise.interactor.wallets.WalletsInteractor
import com.p2ptestexercise.interactor.wallets.WalletsInteractorImpl
import com.p2ptestexercise.ui.authorization.presenter.AuthorizationPresenter
import com.p2ptestexercise.ui.authorization.presenter.AuthorizationPresenterImp
import com.p2ptestexercise.ui.authorization.view.AuthorizationView
import com.p2ptestexercise.ui.main.presenter.MainPresenter
import com.p2ptestexercise.ui.main.presenter.MainPresenterImpl
import com.p2ptestexercise.ui.main.view.MainView
import com.p2ptestexercise.ui.wallets.presenter.WalletsPresenter
import com.p2ptestexercise.ui.wallets.presenter.WalletsPresenterImpl
import com.p2ptestexercise.ui.wallets.view.WalletsView
import com.p2ptestexercise.util.StringService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory<MainPresenter<MainView>> { MainPresenterImpl(get()) }

    factory<AuthorizationPresenter<AuthorizationView>> { AuthorizationPresenterImp(get(), get()) }

    factory<WalletsPresenter<WalletsView>> { WalletsPresenterImpl(get(), get()) }

    single<MainInteractor> { MainInteractorImpl(get()) }

    single<AuthorizationInteractor> { AuthorizationInteractorImpl(get()) }

    single<WalletsInteractor> { WalletsInteractorImpl(get(), get(), get()) }

    single<AuthorizationRepository> { AuthorizationRepositoryImpl(get()) }

    single<WalletsRepository> { WalletsRepositoryImpl(get()) }

    single { StringService(androidContext()) }

    single<SharedPreferences> {
        androidContext().getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)
    }
}
