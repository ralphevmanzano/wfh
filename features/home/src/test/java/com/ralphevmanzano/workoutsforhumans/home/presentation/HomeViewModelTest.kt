package com.ralphevmanzano.workoutsforhumans.home.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import com.ralphevmanzano.workoutsforhumans.core.domain.repository.WorkoutRepository
import com.ralphevmanzano.workoutsforhumans.core.domain.usecase.LoadWorkoutsUseCase
import com.ralphevmanzano.workoutsforhumans.test_utils.MainCoroutineScopeRule
import com.ralphevmanzano.workoutsforhumans.test_utils.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
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
class HomeViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineScope = MainCoroutineScopeRule()

    @Mock
    private lateinit var repository: WorkoutRepository

    private lateinit var loadWorkoutsUseCase: LoadWorkoutsUseCase

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        loadWorkoutsUseCase = LoadWorkoutsUseCase(repository)
    }

    @Test
    fun `when getWorkouts should update livedata`() {
        coroutineScope.runBlockingTest {
            // Given
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
            `when`(loadWorkoutsUseCase.invoke()).thenReturn(flowOf(workouts))

            // When
            val viewModel = HomeViewModel(loadWorkoutsUseCase)

            // Then
            val result = viewModel.workouts.getOrAwaitValue()
            assertEquals(1, result.size)
            assertEquals(0, result[0].id)
            assertEquals("Push up", result[0].title)
            assertEquals("Push up", result[0].name)
            assertEquals("img_push_up", result[0].imgRes)
            assertEquals("intermediate", result[0].difficulty)
            assertEquals("no equipment", result[0].equipment)
            assertEquals("chest", result[0].primaryMuscle)
            assertEquals("triceps", result[0].secondaryMuscle)
        }
    }
}