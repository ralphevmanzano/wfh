package com.ralphevmanzano.workoutsforhumans.core.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout

@Entity(tableName = "workout")
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val name: String,
    @ColumnInfo(name = "img_res")
    val imgRes: String,
    val difficulty: String,
    val equipment: String,
    @ColumnInfo(name = "primary_muscle")
    val primaryMuscle: String,
    @ColumnInfo(name = "secondary_muscle")
    val secondaryMuscle: String
) {
    fun toWorkout(): Workout {
        return Workout(id, title, name, imgRes, difficulty, equipment, primaryMuscle, secondaryMuscle)
    }
}