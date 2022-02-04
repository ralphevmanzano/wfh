package com.ralphevmanzano.workoutsforhumans.core.domain.datasource

import com.ralphevmanzano.workoutsforhumans.core.data.local.entities.WorkoutEntity
import kotlinx.coroutines.flow.Flow

interface WorkoutLocalDataSource {
    fun getWorkouts(): Flow<List<WorkoutEntity>>
    suspend fun getWorkoutById(id: Int): WorkoutEntity
}