package com.app.remote.mapper

import com.app.data.entities.BenefitEntity
import com.app.remote.model.BenefitRemote

object BenefitRemoteMapper : BaseRemoteMapper<BenefitRemote, BenefitEntity> {
    override fun mapFromRemote(remoteObject: BenefitRemote): BenefitEntity {
        return  BenefitEntity(
            name = remoteObject.name,
            description = remoteObject.description,
            image = remoteObject.image
        )
    }
}