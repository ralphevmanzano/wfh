package com.ralphevmanzano.workoutsforhumans.core.data

import com.ralphevmanzano.workoutsforhumans.core.data.local.entities.WorkoutEntity
import com.ralphevmanzano.workoutsforhumans.core.domain.datasource.WorkoutLocalDataSource
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class WorkoutRepositoryImplTest {

    @Mock
    private lateinit var localDataSource: WorkoutLocalDataSource

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @Test
    fun `when getWorkouts is called, should call local getWorkouts`() {
        runTest {
            // Given
            val repoImpl = WorkoutRepositoryImpl(localDataSource)
            val workoutEntities = listOf(
                WorkoutEntity(
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
            val localFlow = flow { emit(workoutEntities) }
            `when`(localDataSource.getWorkouts()).thenReturn(localFlow)

            // When
            val result = repoImpl.getWorkouts().toList()

            // Then
            verify(localDataSource, Mockito.times(1)).getWorkouts()
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

            assertEquals(resultWorkout, expectedWorkout)
            assertEquals(resultWorkout.id, expectedWorkout.id)
            assertEquals(resultWorkout.title, expectedWorkout.title)
            assertEquals(resultWorkout.name, expectedWorkout.name)
            assertEquals(resultWorkout.imgRes, expectedWorkout.imgRes)
            assertEquals(resultWorkout.difficulty, expectedWorkout.difficulty)
            assertEquals(resultWorkout.equipment, expectedWorkout.equipment)
            assertEquals(resultWorkout.primaryMuscle, expectedWorkout.primaryMuscle)
            assertEquals(resultWorkout.secondaryMuscle, expectedWorkout.secondaryMuscle)
        }
    }

    @Test
    fun `when getWorkoutsById is called, should call local getWorkoutById`() {
        runTest {
            // Given
            val repoImpl = WorkoutRepositoryImpl(localDataSource)
            val id = 0
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
            `when`(localDataSource.getWorkoutById(id)).thenReturn(workoutEntity)

            // When
            val result = repoImpl.getWorkoutById(id)

            // Then
            verify(localDataSource, Mockito.times(1)).getWorkoutById(0)
            val expected =
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

            assertEquals(result, expected)
            assertEquals(result.id, expected.id)
            assertEquals(result.title, expected.title)
            assertEquals(result.name, expected.name)
            assertEquals(result.imgRes, expected.imgRes)
            assertEquals(result.difficulty, expected.difficulty)
            assertEquals(result.equipment, expected.equipment)
            assertEquals(result.primaryMuscle, expected.primaryMuscle)
            assertEquals(result.secondaryMuscle, expected.secondaryMuscle)
        }
    }
}