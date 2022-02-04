package com.ralphevmanzano.workoutsforhumans.details.presentation

import androidx.lifecycle.Observer
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import com.ralphevmanzano.workoutsforhumans.core.domain.repository.WorkoutRepository
import com.ralphevmanzano.workoutsforhumans.core.domain.usecase.LoadWorkoutByIdUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailsViewModelTest {

    @Mock
    private lateinit var repository: WorkoutRepository

    @Mock
    private lateinit var observer: Observer<Workout>

    @Captor
    private lateinit var captor: ArgumentCaptor<Workout>

    private lateinit var viewModel: DetailsViewModel

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        viewModel = DetailsViewModel(LoadWorkoutByIdUseCase(repository))
    }

    @Test
    fun `when getWorkoutsById should update livedata`() {
        runTest {
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
            `when`(repository.getWorkoutById(id)).thenReturn(workout)

            // When
            viewModel.getWorkout(id)

            // Then
            
        }
    }
}