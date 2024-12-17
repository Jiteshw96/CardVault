package com.app.data.entities

data class CreditCardEntity(
    val name: String,
    val image: Int,
    val benefits: List<BenefitEntity>
)
