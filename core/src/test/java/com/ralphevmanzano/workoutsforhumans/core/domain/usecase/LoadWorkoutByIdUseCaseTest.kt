package com.ralphevmanzano.workoutsforhumans.core.domain.usecase

import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import com.ralphevmanzano.workoutsforhumans.core.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
class LoadWorkoutByIdUseCaseTest {

    @Mock
    private lateinit var repository: WorkoutRepository

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @Test
    fun `when invoked, should call repository getWorkoutById`() {
        runTest {
            // Given
            val loadWorkoutByIdUseCase = LoadWorkoutByIdUseCase(repository)
            val id = 0
            val workout = Workout(
                0,
                "Push up",
                "Push up",
                "img_push_up",
                "intermediate",
                "no equipment",
                "chest",
                "triceps"
            )
            `when`(loadWorkoutByIdUseCase(id)).thenReturn(workout)

            // When
            val result = loadWorkoutByIdUseCase(id)

            // Then
            verify(repository, times(1)).getWorkoutById(id)
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
}