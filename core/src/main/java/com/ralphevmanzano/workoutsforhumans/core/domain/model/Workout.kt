package com.ralphevmanzano.workoutsforhumans.core.domain.model

import androidx.annotation.DrawableRes
import com.ralphevmanzano.workoutsforhumans.core.utils.WorkoutDifficulty

data class Workout(
  val id: Int,
  val title: String,
  val name: String,
  val imgRes: String,
  @WorkoutDifficulty val difficulty: String,
  val equipment: String,
  val primaryMuscle: String,
  val secondaryMuscle: String
)