package com.ralphevmanzano.workoutsforhumans.application.navigation

import androidx.navigation.NavController
import com.ralphevmanzano.workoutsforhumans.details.navigation.DetailsNavigation
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DetailsNavigator @Inject constructor(
    private val navController: NavController
): DetailsNavigation {

    override fun backToHome() {
        navController.navigateUp()
    }
}