package com.app.remote.service

import com.app.remote.data.CreditCardData

class ApiService {

    suspend fun fetchRemoteCreditCards() = CreditCardData.creditCardRemoteData
    
}