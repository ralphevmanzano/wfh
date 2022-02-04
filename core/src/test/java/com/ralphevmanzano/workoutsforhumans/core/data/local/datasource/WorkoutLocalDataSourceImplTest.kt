package com.ralphevmanzano.workoutsforhumans.core.data.local.datasource

import com.ralphevmanzano.workoutsforhumans.core.data.local.dao.WorkoutDao
import com.ralphevmanzano.workoutsforhumans.core.data.local.entities.WorkoutEntity
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
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class WorkoutLocalDataSourceImplTest {

    @Mock
    private lateinit var dao: WorkoutDao
    private val testDispatcher = StandardTestDispatcher()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `when getWorkouts is called, should call dao getWorkouts`() {
        runTest {
            // Given
            val dataSourceImpl = WorkoutLocalDataSourceImpl(dao, testDispatcher)
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
            val daoFlow = flow { emit(workoutEntities) }
            `when`(dao.getWorkouts()).thenReturn(daoFlow)

            // When
            val result = dataSourceImpl.getWorkouts().toList()

            // Then
            verify(dao, times(1)).getWorkouts()
            val expected = listOf(
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
            val resultWorkout = result[0][0]
            val expectedWorkout = expected[0]

            assertEquals(expected.size, result[0].size)
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

    @Test
    fun `when getWorkoutById is called, should call dao getWorkoutById`() {
        runTest {
            // Given
            val dataSourceImpl = WorkoutLocalDataSourceImpl(dao, testDispatcher)
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
            `when`(dao.getWorkoutById(id)).thenReturn(workoutEntity)

            // When
            val result = dataSourceImpl.getWorkoutById(id)

            // Then
            verify(dao, times(1)).getWorkoutById(id)

            assertEquals(workoutEntity, result)
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