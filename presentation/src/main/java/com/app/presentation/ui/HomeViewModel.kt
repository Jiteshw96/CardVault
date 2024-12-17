package com.app.presentation.ui

import androidx.lifecycle.viewModelScope
import com.app.domain.common.Result
import com.app.domain.model.Benefit
import com.app.domain.usecase.GetCreditCardsUseCase
import com.app.presentation.base.BaseViewModel
import com.app.presentation.mapper.ResultMapper
import com.app.presentation.model.BottomSheetInsights
import com.app.presentation.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val getCreditCardsUseCase: GetCreditCardsUseCase
) : BaseViewModel<HomeUiState>() {

    val searchQuery = MutableStateFlow("")
    val currentSelectedItem = MutableStateFlow(-1)

    override fun setInitialState(): HomeUiState = HomeUiState.Nothing

    val homeUiState: StateFlow<HomeUiState> = getCreditCardsUseCase.invoke()
        .map { resultState ->
            when (resultState) {
                is Result.SuccessState -> ResultMapper.homeStateSuccessMapper(resultState = resultState)
                is Result.ErrorState -> ResultMapper.homeStateErrorMapper(resultState = resultState)
            }
        }.onStart { emit(HomeUiState.Loading) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState.Loading,
        )

    val rewardsList: StateFlow<List<Benefit>> = combine(
        homeUiState, currentSelectedItem
    ) { uiState, index ->
        (uiState as? HomeUiState.Success)?.cardList?.get(index)?.benefits.orEmpty()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList(),
    )


    val filterRewardsList: StateFlow<List<Benefit>> = combine(
        rewardsList, searchQuery
    ) { rewardsList, query ->
        if (query.isNotEmpty()) {
            val pattern = ".*$searchQuery.*"
            val regex = Regex(pattern, RegexOption.IGNORE_CASE)
            rewardsList.filter { rewards ->
                rewards.name.matches(regex)
            }
        } else {
            rewardsList
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList(),
    )


    val bottomSheetInsights: StateFlow<BottomSheetInsights> = rewardsList
        .map { rewardsList ->
            val characterMap = findTopResults(rewardsList)
            BottomSheetInsights(itemCount = characterMap.size, characterOccurrences = characterMap)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = BottomSheetInsights(itemCount = 0, characterOccurrences = emptyMap()),
        )


    private fun findTopResults(
        rewardsList: List<Benefit>,
        numberOfItems: Int = 3,
    ): Map<Char, Int> {
        val characters = hashMapOf<Char, Int>()
        for (item in rewardsList) {
            for (data in item.name) {
                if(!data.isWhitespace()){
                    characters[data] = (characters[data] ?: 0) + 1
                }
            }
        }
        val sortedMap = characters.entries.sortedByDescending { it.value }
            .take(numberOfItems)
            .associate { it.key to it.value }

        return sortedMap
    }
}