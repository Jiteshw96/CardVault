package com.app.data.mapper.entitymapper

import com.app.data.entities.BenefitEntity
import com.app.domain.model.Benefit

object BenefitEntityMapper : BaseEntityMapper<BenefitEntity, Benefit> {
    override fun mapFromEntity(remoteObject: BenefitEntity): Benefit {
        return  Benefit(
            name = remoteObject.name,
            description = remoteObject.description,
            image = remoteObject.image
        )
    }
}