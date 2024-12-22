package com.app.remote.di

import com.app.data.datasource.remote.CreditCardsRemoteDataSource
import com.app.remote.service.ApiService
import com.app.remote.source.CreditCardsRemoteDataSourceImpl

import org.koin.dsl.module



val remoteModule = module {
    single<CreditCardsRemoteDataSource> { CreditCardsRemoteDataSourceImpl(get())  }

    single { ApiService()  }
}