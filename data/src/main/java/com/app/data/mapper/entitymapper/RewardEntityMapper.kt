package com.app.data.mapper.entitymapper

import com.app.data.entities.RewardEntity
import com.app.domain.model.Reward

object RewardEntityMapper : BaseEntityMapper<RewardEntity, Reward> {
    override fun mapFromEntity(remoteObject: RewardEntity): Reward {
        return Reward(
            name = remoteObject.name,
            description = remoteObject.description,
            image = remoteObject.image
        )
    }
}