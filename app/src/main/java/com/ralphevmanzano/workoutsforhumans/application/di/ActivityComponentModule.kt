package com.ralphevmanzano.workoutsforhumans.application.di

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ralphevmanzano.workoutsforhumans.R
import com.ralphevmanzano.workoutsforhumans.application.navigation.DetailsNavigator
import com.ralphevmanzano.workoutsforhumans.application.navigation.HomeNavigator
import com.ralphevmanzano.workoutsforhumans.details.navigation.DetailsNavigation
import com.ralphevmanzano.workoutsforhumans.home.navigation.HomeNavigation
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object NavControllerModule {

    @Provides
    fun navController(activity: FragmentActivity): NavController {
        return NavHostFragment.findNavController(activity.supportFragmentManager.findFragmentById(R.id.nav_host)!!)
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigatorModule {

    @Binds
    abstract fun homeNavigator(navigator: HomeNavigator): HomeNavigation

    @Binds
    abstract fun detailsNavigator(navigator: DetailsNavigator): DetailsNavigation

    // add other navigators here
}