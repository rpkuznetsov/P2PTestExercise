package com.p2ptestexercise.di

import com.p2ptestexercise.common.HOST_URL
import com.p2ptestexercise.data.wallets.Api
import com.p2ptestexercise.util.ApiUtils
import org.koin.dsl.module

val apiModule = module {
    single { ApiUtils.createHttpClient() }
    single { ApiUtils.createGsonConverter() }
    single { ApiUtils.createRetrofit(get(), get(), HOST_URL) }
    single { ApiUtils.getApi<Api>(get()) }
}
