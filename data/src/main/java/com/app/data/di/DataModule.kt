package com.app.data.di

import com.app.data.repository.CreditCardsRepositoryImpl
import com.app.domain.repository.CreditCardsRepository
import com.app.domain.usecase.GetCreditCardsUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


val dataModule = module {

    single { Dispatchers.IO }

    single<CreditCardsRepository> { CreditCardsRepositoryImpl(get(), get()) }

    single { GetCreditCardsUseCase(get()) }
}