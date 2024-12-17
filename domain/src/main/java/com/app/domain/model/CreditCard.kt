package com.app.domain.model

data class CreditCard(
    val name: String,
    val image: Int,
    val benefits: List<Benefit>
)
