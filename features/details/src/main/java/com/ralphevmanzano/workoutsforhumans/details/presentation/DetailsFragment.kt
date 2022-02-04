package com.ralphevmanzano.workoutsforhumans.details.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ralphevmanzano.workoutsforhumans.common.extensions.setImageDrawableFromString
import com.ralphevmanzano.workoutsforhumans.common.extensions.toCapitalize
import com.ralphevmanzano.workoutsforhumans.core.base.BaseFragment
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import com.ralphevmanzano.workoutsforhumans.core.utils.BEGINNER
import com.ralphevmanzano.workoutsforhumans.core.utils.EXPERT
import com.ralphevmanzano.workoutsforhumans.core.utils.INTERMEDIATE
import com.ralphevmanzano.workoutsforhumans.core.utils.WorkoutDifficulty
import com.ralphevmanzano.workoutsforhumans.details.R
import com.ralphevmanzano.workoutsforhumans.details.databinding.FragmentDetailsBinding
import com.ralphevmanzano.workoutsforhumans.details.navigation.DetailsNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    private val viewModel by viewModels<DetailsViewModel>()
    private val args by navArgs<DetailsFragmentArgs>()

    @Inject
    lateinit var detailsNavigation: DetailsNavigation

    override fun getViewBinding() = FragmentDetailsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getWorkout(args.id)
    }

    override fun setupViews() = with(binding) {
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.setNavigationOnClickListener {
            detailsNavigation.backToHome()
        }
    }

    override fun observeData() {
        viewModel.workout.observe(viewLifecycleOwner) {
            updateUi(it)
        }
    }

    private fun updateUi(workout: Workout) = with(binding) {
        tvWorkout.text = workout.name
        tvDifficulty.text = workout.difficulty.toCapitalize()
        tvEquipment.text = workout.equipment
        tvPrimaryMuscles.text = workout.primaryMuscle
        tvSecondaryMuscles.text = workout.secondaryMuscle
        pbDifficulty.progress = getDifficultyLevel(workout.difficulty)
        ivWorkout.setImageDrawableFromString(workout.imgRes)
    }

    private fun getDifficultyLevel(@WorkoutDifficulty difficulty: String): Int {
        return when (difficulty) {
            BEGINNER -> BEGINNER_LEVEL
            INTERMEDIATE -> INTERMEDIATE_LEVEL
            EXPERT -> EXPERT_LEVEL
            else -> ZERO_LEVEL
        }
    }

    companion object {
        const val BEGINNER_LEVEL = 33
        const val INTERMEDIATE_LEVEL = 66
        const val EXPERT_LEVEL = 100
        const val ZERO_LEVEL = 0
    }
}