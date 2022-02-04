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
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
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
            verify(dao, Mockito.times(1)).getWorkouts()

            val resultWorkout = result[0][0]

            assertEquals(resultWorkout, workoutEntities[0])
            assertEquals(resultWorkout.id, 0)
            assertEquals(resultWorkout.title, "Push up")
            assertEquals(resultWorkout.name, "Push up")
            assertEquals(resultWorkout.imgRes, "img_push_up")
            assertEquals(resultWorkout.difficulty, "intermediate")
            assertEquals(resultWorkout.equipment, "no equipment")
            assertEquals(resultWorkout.primaryMuscle, "chest")
            assertEquals(resultWorkout.secondaryMuscle, "triceps")
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
            verify(dao, Mockito.times(1)).getWorkoutById(id)

            assertEquals(result, workoutEntity)
            assertEquals(result.id, 0)
            assertEquals(result.title, "Push up")
            assertEquals(result.name, "Push up")
            assertEquals(result.imgRes, "img_push_up")
            assertEquals(result.difficulty, "intermediate")
            assertEquals(result.equipment, "no equipment")
            assertEquals(result.primaryMuscle, "chest")
            assertEquals(result.secondaryMuscle, "triceps")
        }
    }
}