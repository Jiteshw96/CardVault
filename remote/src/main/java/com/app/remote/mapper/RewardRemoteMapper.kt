package com.app.remote.mapper

import com.app.data.entities.RewardEntity
import com.app.remote.model.RewardRemote

object RewardRemoteMapper : BaseRemoteMapper<RewardRemote, RewardEntity> {
    override fun mapFromRemote(remoteObject: RewardRemote): RewardEntity {
        return  RewardEntity(
            name = remoteObject.name,
            description = remoteObject.description,
            image = remoteObject.image
        )
    }
}