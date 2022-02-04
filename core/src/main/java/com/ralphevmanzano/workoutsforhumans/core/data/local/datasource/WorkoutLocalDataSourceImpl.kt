package com.ralphevmanzano.workoutsforhumans.core.data.local.datasource

import com.ralphevmanzano.workoutsforhumans.core.data.local.dao.WorkoutDao
import com.ralphevmanzano.workoutsforhumans.core.data.local.entities.WorkoutEntity
import com.ralphevmanzano.workoutsforhumans.core.domain.datasource.WorkoutLocalDataSource
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WorkoutLocalDataSourceImpl @Inject constructor(
    private val workoutDao: WorkoutDao,
    private val dispatcher: CoroutineDispatcher
) : WorkoutLocalDataSource {
    override fun getWorkouts(): Flow<List<WorkoutEntity>> {
        return workoutDao.getWorkouts().flowOn(dispatcher)
    }

    override suspend fun getWorkoutById(id: Int): WorkoutEntity = withContext(dispatcher) {
        return@withContext workoutDao.getWorkoutById(id)
    }
}