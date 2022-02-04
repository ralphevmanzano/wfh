package com.ralphevmanzano.workoutsforhumans.core.domain.usecase

import com.ralphevmanzano.workoutsforhumans.core.domain.repository.WorkoutRepository
import javax.inject.Inject

class LoadWorkoutByIdUseCase @Inject constructor(private val repo: WorkoutRepository) {
    suspend operator fun invoke(id: Int) = repo.getWorkoutById(id)
}