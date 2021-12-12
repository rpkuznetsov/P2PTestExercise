package com.p2ptestexercise.di

import android.content.Context
import android.content.SharedPreferences
import com.p2ptestexercise.data.authorization.AuthorizationRepository
import com.p2ptestexercise.data.authorization.AuthorizationRepositoryImpl
import com.p2ptestexercise.data.authorization.PREFERENCES_FILE_KEY
import com.p2ptestexercise.interactor.authorization.AuthorizationInteractorImpl
import com.p2ptestexercise.interactor.authorization.AuthorizationInteractor
import com.p2ptestexercise.ui.authorization.presenter.AuthorizationPresenter
import com.p2ptestexercise.ui.authorization.presenter.AuthorizationPresenterImp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory<AuthorizationPresenter> { AuthorizationPresenterImp(get()) }

    factory<AuthorizationInteractor> { AuthorizationInteractorImpl(get()) }

    factory<AuthorizationRepository> { AuthorizationRepositoryImpl(get()) }

    single<SharedPreferences> {
        androidContext().getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)
    }
}
