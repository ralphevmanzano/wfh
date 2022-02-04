package com.ralphevmanzano.workoutsforhumans.details.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import com.ralphevmanzano.workoutsforhumans.core.domain.repository.WorkoutRepository
import com.ralphevmanzano.workoutsforhumans.core.domain.usecase.LoadWorkoutByIdUseCase
import com.ralphevmanzano.workoutsforhumans.test_utils.MainCoroutineScopeRule
import com.ralphevmanzano.workoutsforhumans.test_utils.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailsViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineScope = MainCoroutineScopeRule()

    @Mock
    private lateinit var repository: WorkoutRepository

    private lateinit var loadWorkoutByIdUseCase: LoadWorkoutByIdUseCase

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        loadWorkoutByIdUseCase = LoadWorkoutByIdUseCase(repository)
    }

    @Test
    fun `when getWorkoutById should update livedata`() {
        coroutineScope.runBlockingTest {
            // Given
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
            `when`(loadWorkoutByIdUseCase.invoke(id)).thenReturn(workout)

            // When
            val viewModel = DetailsViewModel(loadWorkoutByIdUseCase)
            viewModel.getWorkout(id)

            // Then
            val result = viewModel.workout.getOrAwaitValue()
            assertEquals(0, result.id)
            assertEquals("Push up", result.title)
            assertEquals("Push up", result.name)
            assertEquals("img_push_up", result.imgRes)
            assertEquals("intermediate", result.difficulty)
            assertEquals("no equipment", result.equipment)
            assertEquals("chest", result.primaryMuscle)
            assertEquals("triceps", result.secondaryMuscle)
        }
    }
}