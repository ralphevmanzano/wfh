package com.ralphevmanzano.workoutsforhumans.core.domain.repository

import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import kotlinx.coroutines.flow.Flow

interface WorkoutRepository {
    fun getWorkouts(): Flow<List<Workout>>
    suspend fun getWorkoutById(id: Int): Workout
}