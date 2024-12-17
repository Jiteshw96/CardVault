package com.app.remote.service

import com.app.remote.data.CreditCardData
import org.koin.core.annotation.Single


class ApiService {

    suspend fun fetchRemoteCreditCards() = CreditCardData.creditCardRemoteData
    
}