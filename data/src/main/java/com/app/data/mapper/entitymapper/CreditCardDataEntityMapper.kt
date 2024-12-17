package com.app.data.mapper.entitymapper

import com.app.data.CreditCardDataEntity
import com.app.domain.model.CreditCardData

object CreditCardDataEntityMapper :
    BaseEntityMapper<CreditCardDataEntity, CreditCardData> {
    override fun mapFromEntity(remoteObject: CreditCardDataEntity): CreditCardData {
        return  CreditCardData(
            creditCards = remoteObject.creditCards.map { creditCardRemote ->
                CreditCardEntityMapper.mapFromEntity(creditCardRemote)
            }
        )
    }
}