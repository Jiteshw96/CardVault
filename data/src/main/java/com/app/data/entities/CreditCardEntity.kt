package com.app.data.entities

data class CreditCardEntity(
    val name: String,
    val image: Int,
    val rewards: List<RewardEntity>
)
