package com.app.presentation.mapper

import com.app.domain.common.Result
import com.app.domain.model.CreditCardData
import com.app.presentation.R
import com.app.presentation.state.HomeUiState

object ResultMapper {
    fun <T> homeStateErrorMapper(resultState: Result.ErrorState<T>): HomeUiState.Error {
        return when {
            resultState.message != null -> HomeUiState.Error(resourceId = resultState.message)
            resultState.responseMessage != null -> HomeUiState.Error(stringMessage = resultState.responseMessage)
            else -> {
                HomeUiState.Error(resourceId = R.string.generic_error)
            }
        }
    }

    fun homeStateSuccessMapper(resultState: Result.SuccessState<CreditCardData>) =
        HomeUiState.Success(
            cardList = resultState.data.creditCards,
            carouselImages = resultState.data.creditCards.map { it.image },
        )
}