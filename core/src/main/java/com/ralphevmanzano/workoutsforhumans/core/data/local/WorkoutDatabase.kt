package com.ralphevmanzano.workoutsforhumans.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ralphevmanzano.workoutsforhumans.core.data.local.dao.WorkoutDao
import com.ralphevmanzano.workoutsforhumans.core.data.local.entities.WorkoutEntity
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout

@Database(entities = [WorkoutEntity::class], version = 1)
abstract class WorkoutDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
}