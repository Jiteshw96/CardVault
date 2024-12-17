package com.app.presentation.state

import androidx.annotation.StringRes
import com.app.domain.model.Benefit
import com.app.domain.model.CreditCard

sealed interface HomeUiState {
   data object Loading : HomeUiState

   data class Success(
       val cardList:List<CreditCard>? = null,
       val carouselImages:List<Int>? = null
   ):HomeUiState

    data class Error(
        val stringMessage:String? = null,
        @StringRes val resourceId:Int? = null
    ):HomeUiState

   data object Nothing:HomeUiState
}