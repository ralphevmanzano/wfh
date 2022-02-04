package com.ralphevmanzano.workoutsforhumans.core.data.local.entities

import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import org.junit.Assert.*
import org.junit.Test

class WorkoutEntityTest {
    @Test
    fun `toWorkout should return expected`() {
        // Given
        val workoutEntity = WorkoutEntity(
            0,
            "Push up",
            "Push up",
            "img_push_up",
            "intermediate",
            "no equipment",
            "chest",
            "triceps"
        )

        // When
        val result = workoutEntity.toWorkout()

        // Then
        val expected = Workout(
            0,
            "Push up",
            "Push up",
            "img_push_up",
            "intermediate",
            "no equipment",
            "chest",
            "triceps"
        )

        assertEquals(expected, result)
        assertEquals(expected.id, result.id)
        assertEquals(expected.title, result.title)
        assertEquals(expected.name, result.name)
        assertEquals(expected.imgRes, result.imgRes)
        assertEquals(expected.difficulty, result.difficulty)
        assertEquals(expected.equipment, result.equipment)
        assertEquals(expected.primaryMuscle, result.primaryMuscle)
        assertEquals(expected.secondaryMuscle, result.secondaryMuscle)
    }
}