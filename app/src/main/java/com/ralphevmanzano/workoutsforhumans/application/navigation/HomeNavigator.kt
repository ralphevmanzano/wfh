package com.ralphevmanzano.workoutsforhumans.application.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ralphevmanzano.workoutsforhumans.NavigationMainDirections
import com.ralphevmanzano.workoutsforhumans.R
import com.ralphevmanzano.workoutsforhumans.home.navigation.HomeNavigation
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class HomeNavigator @Inject constructor(
        private val navController: NavController
) : HomeNavigation {

    override fun navigateToDetails(id: Int) {
        navController.navigate(NavigationMainDirections.actionHomeToDetails(id))
    }
}