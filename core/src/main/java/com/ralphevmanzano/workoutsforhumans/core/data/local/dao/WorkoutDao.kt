package com.ralphevmanzano.workoutsforhumans.core.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.ralphevmanzano.workoutsforhumans.core.data.local.entities.WorkoutEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM workout ORDER BY id ASC")
    fun getWorkouts(): Flow<List<WorkoutEntity>>

    @Query("SELECT * FROM workout WHERE id = :id")
    suspend fun getWorkoutById(id: Int): WorkoutEntity
}