package com.ralphevmanzano.workoutsforhumans.core.data

import com.ralphevmanzano.workoutsforhumans.core.domain.datasource.WorkoutLocalDataSource
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import com.ralphevmanzano.workoutsforhumans.core.domain.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor(
    private val localDataSource: WorkoutLocalDataSource
) : WorkoutRepository {
    override fun getWorkouts(): Flow<List<Workout>> {
        return localDataSource.getWorkouts().map { workouts ->
            workouts.map { it.toWorkout() }
        }
    }

    override suspend fun getWorkoutById(id: Int): Workout {
        return localDataSource.getWorkoutById(id).toWorkout()
    }
}