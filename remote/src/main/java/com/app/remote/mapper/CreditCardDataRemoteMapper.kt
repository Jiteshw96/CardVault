package com.app.remote.mapper

import com.app.data.CreditCardDataEntity
import com.app.remote.model.CreditCardDataRemote

object CreditCardDataRemoteMapper : BaseRemoteMapper<CreditCardDataRemote, CreditCardDataEntity> {
    override fun mapFromRemote(remoteObject: CreditCardDataRemote): CreditCardDataEntity {
        return  CreditCardDataEntity(
            creditCards = remoteObject.creditCards.map { creditCardRemote ->
                CreditCardRemoteMapper.mapFromRemote(creditCardRemote)
            }
        )
    }
}