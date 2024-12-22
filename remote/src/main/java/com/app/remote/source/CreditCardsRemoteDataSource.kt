package com.app.remote.source

import com.app.data.CreditCardDataEntity
import com.app.data.datasource.remote.CreditCardsRemoteDataSource
import com.app.remote.mapper.CreditCardDataRemoteMapper
import com.app.remote.service.ApiService


class CreditCardsRemoteDataSourceImpl(
    private val apiService: ApiService,
) : CreditCardsRemoteDataSource {
    override suspend fun fetchCreditCards(): CreditCardDataEntity =
        CreditCardDataRemoteMapper.mapFromRemote(apiService.fetchRemoteCreditCards())
}