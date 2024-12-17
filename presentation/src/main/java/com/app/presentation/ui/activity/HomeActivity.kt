package com.app.presentation.ui.activity


import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.app.domain.model.Benefit
import com.app.presentation.R
import com.app.presentation.base.BaseActivity
import com.app.presentation.databinding.ActivityHomeBinding
import com.app.presentation.state.HomeUiState
import com.app.presentation.ui.adapter.CardCarouselAdapter
import com.app.presentation.ui.adapter.RewardAdapter
import com.app.presentation.ui.dialog.BottomSheetDialog
import com.app.presentation.utils.extension.ViewExtension.showToast
import com.app.presentation.utils.extension.ViewExtension.visibilityToggle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {


    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var rewardsAdapter: RewardAdapter
    private lateinit var cardCarouselAdapter: CardCarouselAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
    }

    override fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    homeViewModel.homeUiState.collectLatest { state ->
                        when (state) {
                            is HomeUiState.Success -> {
                                dataBinding.progressBar.visibilityToggle(false)
                                homeViewModel.currentSelectedItem.value = 0
                                setDataAdapter(
                                    carouselData = state.carouselImages ?: emptyList(),
                                )
                            }

                            is HomeUiState.Loading -> {
                                dataBinding.progressBar.visibilityToggle(true)
                            }

                            is HomeUiState.Error -> {
                                dataBinding.progressBar.visibilityToggle(false)
                                val message = state.stringMessage ?: getString(
                                    state.resourceId ?: R.string.generic_error
                                )
                                showToast(message)
                            }

                            else -> {

                            }
                        }
                    }
                }

                launch {
                    homeViewModel.rewardsList.collectLatest { list ->
                        setRewardsAdapter(list)
                    }
                }
            }
        }
    }

    override fun initViews() {
        dataBinding.fab.setOnClickListener {
            val bottomSheetDetails = homeViewModel.bottomSheetInsights.value
            val modal = BottomSheetDialog(bottomSheetDetails)
            supportFragmentManager.let { modal.show(it, BottomSheetDialog.TAG) }

        }

        dataBinding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                query?.let {
                    homeViewModel.searchQuery.value = query
                }
                return true
            }
        })

        dataBinding.homeCarousel.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                homeViewModel.currentSelectedItem.value = position
                resetSearchQuery()
            }
        })
    }


    private fun setDataAdapter(
        carouselData: List<Int>
    ) {
        cardCarouselAdapter = CardCarouselAdapter(carouselData)
        dataBinding.apply {
            homeCarousel.viewPager.adapter = cardCarouselAdapter
            TabLayoutMediator(homeCarousel.tabLayout, homeCarousel.viewPager) { tab, position ->
            }.attach()
        }
    }

    private fun setRewardsAdapter(
        rewardsData: List<Benefit>
    ) {
        rewardsAdapter = RewardAdapter(rewardsData)
        dataBinding.apply {
            itemList.adapter = rewardsAdapter
            itemList.layoutManager = LinearLayoutManager(this@HomeActivity)

        }
    }


    fun resetSearchQuery() {
        dataBinding.search.setQuery("", false)
        dataBinding.search.clearFocus()
    }
}