package com.app.data.repository

import com.app.data.SafeApiCall
import com.app.data.datasource.remote.CreditCardsRemoteDataSource
import com.app.data.mapper.entitymapper.CreditCardDataEntityMapper
import com.app.domain.common.Result
import com.app.domain.model.CreditCardData
import com.app.domain.repository.CreditCardsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CreditCardsRepositoryImpl (
    private val creditCardsRemoteDataSource: CreditCardsRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : CreditCardsRepository{

    override suspend fun getCreditCards() : Result<CreditCardData> = SafeApiCall.execute(
        dispatcher = dispatcher,
        apiCall = { CreditCardDataEntityMapper.mapFromRemote(creditCardsRemoteDataSource.fetchCreditCards()) }
    )
}