package com.ralphevmanzano.workoutsforhumans.core.domain.usecase

import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import com.ralphevmanzano.workoutsforhumans.core.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class LoadWorkoutsUseCaseTest {

    @Mock
    private lateinit var repository: WorkoutRepository

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @Test
    fun `when invoked, should call repository getWorkouts`() {
        runTest {
            // Given
            val loadWorkouts = LoadWorkoutsUseCase(repository)
            val workouts = listOf(
                Workout(
                    0,
                    "Push up",
                    "Push up",
                    "img_push_up",
                    "intermediate",
                    "no equipment",
                    "chest",
                    "triceps"
                )
            )
            val localFlow = flow { emit(workouts) }
            `when`(loadWorkouts()).thenReturn(localFlow)

            // When
            val result = loadWorkouts().toList()

            // Then
            verify(repository, times(1)).getWorkouts()
            val expected = listOf(
                Workout(
                    0,
                    "Push up",
                    "Push up",
                    "img_push_up",
                    "intermediate",
                    "no equipment",
                    "chest",
                    "triceps"
                )
            )

            val resultWorkout = result[0][0]
            val expectedWorkout = expected[0]

            assertEquals(expectedWorkout, resultWorkout)
            assertEquals(expectedWorkout.id, resultWorkout.id)
            assertEquals(expectedWorkout.title, resultWorkout.title)
            assertEquals(expectedWorkout.name, resultWorkout.name)
            assertEquals(expectedWorkout.imgRes, resultWorkout.imgRes)
            assertEquals(expectedWorkout.difficulty, resultWorkout.difficulty)
            assertEquals(expectedWorkout.equipment, resultWorkout.equipment)
            assertEquals(expectedWorkout.primaryMuscle, resultWorkout.primaryMuscle)
            assertEquals(expectedWorkout.secondaryMuscle, resultWorkout.secondaryMuscle)
        }
    }
}