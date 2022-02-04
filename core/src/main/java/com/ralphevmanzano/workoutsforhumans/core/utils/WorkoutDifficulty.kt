package com.ralphevmanzano.workoutsforhumans.core.utils

import androidx.annotation.StringDef

@Retention(AnnotationRetention.SOURCE)
@StringDef(BEGINNER, INTERMEDIATE, EXPERT)
annotation class WorkoutDifficulty

const val BEGINNER = "beginner"
const val INTERMEDIATE = "intermediate"
const val EXPERT = "expert"