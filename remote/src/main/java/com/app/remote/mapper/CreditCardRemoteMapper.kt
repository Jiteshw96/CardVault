package com.app.remote.mapper

import com.app.data.entities.CreditCardEntity
import com.app.remote.model.CreditCardRemote

object CreditCardRemoteMapper : BaseRemoteMapper<CreditCardRemote, CreditCardEntity> {
    override fun mapFromRemote(remoteObject: CreditCardRemote): CreditCardEntity {
       return CreditCardEntity(
            name = remoteObject.name,
            image = remoteObject.image,
            rewards = remoteObject.rewards.map { rewardRemote ->
                RewardRemoteMapper.mapFromRemote(rewardRemote)
            }
        )
    }
}