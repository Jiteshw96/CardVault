package com.app.domain.usecase

import com.app.domain.common.FlowResult
import com.app.domain.model.CreditCardData
import com.app.domain.repository.CreditCardsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCreditCardsUseCase(
    private val creditCardsRepository: CreditCardsRepository
) {
    operator fun invoke(): FlowResult<CreditCardData> = flow {
        val result = creditCardsRepository.getCreditCards()
        emit(result)
        }.flowOn(Dispatchers.IO)
}