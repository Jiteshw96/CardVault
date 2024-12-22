package com.app.presentation.ui.components

import androidx.annotation.LayoutRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.app.presentation.R
import com.app.presentation.theme.LocalCustomColorPalette

@Composable
fun CardCarousel(
    @LayoutRes carouselItems: List<Int>,
    pagerState: PagerState
) {
    Column(modifier = Modifier
        .padding(bottom = dimensionResource(id = R.dimen.margin_large))
        .background(LocalCustomColorPalette.current.screenBackground)
    ) {
        HorizontalPager(state = pagerState) { page ->
            CarouselItem(carouselItems[page])
        }
        LazyRow(
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.dp_10))
                .align(Alignment.CenterHorizontally),
        ) {
            itemsIndexed(
                items = carouselItems
            ) { index, _ ->
                BreadCrumb(isActive = index == pagerState.currentPage)
            }
        }
    }
}

@Preview
@Composable
fun PreviewCarouselCarousel() {
    CardCarousel(
        carouselItems = listOf(R.drawable.bg_splash_gradient, R.drawable.bg_splash_gradient),
        pagerState = rememberPagerState(initialPage = 0,
            pageCount = {
                2
            })
    )
}