package com.ralphevmanzano.workoutsforhumans.home.presentation

import androidx.fragment.app.viewModels
import com.ralphevmanzano.workoutsforhumans.core.base.BaseFragment
import com.ralphevmanzano.workoutsforhumans.home.databinding.FragmentHomeBinding
import com.ralphevmanzano.workoutsforhumans.home.navigation.HomeNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

  private val viewModel by viewModels<HomeViewModel>()

  @Inject
  lateinit var homeNavigator: HomeNavigation

  override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

  private lateinit var adapter: WorkoutsAdapter

  override fun setupViews() = with(binding) {
    adapter = WorkoutsAdapter()
    adapter.onItemClick = { homeNavigator.navigateToDetails(it.id) }
    rvWorkouts.adapter = adapter
  }

  override fun observeData() {
    observeLiveData(viewModel.workouts) {
      if (!it.isNullOrEmpty()) adapter.submitList(it)
    }
  }
}