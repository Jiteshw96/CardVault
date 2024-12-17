package com.app.domain.repository

import com.app.domain.common.Result
import com.app.domain.model.CreditCardData

interface CreditCardsRepository {
    suspend fun getCreditCards(): Result<CreditCardData>
}