package com.filmNet.android.di

import org.koin.core.qualifier.named
import org.koin.dsl.module

const val APP_BASE_URL_ADDRESS = "https://api-v2.filmnet.ir/"
const val APP_NETWORK_TIMEOUT_VALUE = 10000L // 10s


val appModule = module {

    single(named(APP_BASE_URL)) { APP_BASE_URL_ADDRESS }
    single(named(APP_NETWORK_TIMEOUT)) { APP_NETWORK_TIMEOUT_VALUE }

}
