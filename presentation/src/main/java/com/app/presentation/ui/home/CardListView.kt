package com.app.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.app.domain.model.Benefit
import com.app.presentation.R
import com.app.presentation.theme.LocalCustomColorPalette
import com.app.presentation.ui.components.CardCarousel
import com.app.presentation.ui.components.CardItemView
import com.app.presentation.ui.components.SearchInputView


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardListView(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    carouselImage: List<Int>,
    rewardsList: List<Benefit>,
    userQuery: String,
    onSearchChange: (String) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    LazyColumn(
        modifier = modifier
            .background(LocalCustomColorPalette.current.screenBackground)
            .padding(
                start = dimensionResource(R.dimen.margin_large),
                end = dimensionResource(R.dimen.margin_large),
                top = dimensionResource(R.dimen.margin_large),
                bottom = dimensionResource(id = R.dimen.dp_0),
            )
            .wrapContentHeight()
    ) {
        item {
            CardCarousel(
                carouselItems = carouselImage,
                pagerState = pagerState
            )
        }

        stickyHeader {
            Surface(modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.margin_small))) {
                SearchInputView(userQuery) { value ->
                    onSearchChange(value)
                }
            }
        }


        itemsIndexed(rewardsList) { _, cardItem ->
            Column(Modifier.padding(vertical = dimensionResource(id = R.dimen.dp_3))) {
                CardItemView(cardItem)
            }
        }

        item {
            Box(
                modifier = Modifier
                    .padding(bottom = screenHeight * 3 / 4)
            )
        }
    }
}