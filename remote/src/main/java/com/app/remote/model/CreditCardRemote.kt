package com.app.remote.model

data class CreditCardRemote(
    val name: String,
    val image: Int,
    val rewards: List<RewardRemote>
)
