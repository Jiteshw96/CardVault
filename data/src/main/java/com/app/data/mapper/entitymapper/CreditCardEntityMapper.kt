package com.app.data.mapper.entitymapper

import com.app.data.entities.CreditCardEntity
import com.app.domain.model.CreditCard

object CreditCardEntityMapper : BaseEntityMapper<CreditCardEntity, CreditCard> {
    override fun mapFromEntity(remoteObject: CreditCardEntity): CreditCard {
        return CreditCard(
            name = remoteObject.name,
            image = remoteObject.image,
            benefits = remoteObject.benefits.map { benefitRemote ->
                BenefitEntityMapper.mapFromEntity(benefitRemote)
            }
        )
    }
}