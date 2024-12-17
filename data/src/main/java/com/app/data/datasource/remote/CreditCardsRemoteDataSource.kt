package com.app.data.datasource.remote

import com.app.data.CreditCardDataEntity

interface CreditCardsRemoteDataSource {
    suspend fun fetchCreditCards(): CreditCardDataEntity
}