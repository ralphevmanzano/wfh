package com.ralphevmanzano.workoutsforhumans.core.domain.usecase

import com.ralphevmanzano.workoutsforhumans.core.domain.repository.WorkoutRepository
import javax.inject.Inject

class LoadWorkoutsUseCase @Inject constructor(private val repo: WorkoutRepository) {
    operator fun invoke() = repo.getWorkouts()
}