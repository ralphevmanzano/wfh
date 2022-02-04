package com.ralphevmanzano.workoutsforhumans.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import com.ralphevmanzano.workoutsforhumans.core.domain.usecase.LoadWorkoutByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val loadWorkoutByIdUseCase: LoadWorkoutByIdUseCase
) : ViewModel() {

    private val _workout = MutableLiveData<Workout>()
    val workout: LiveData<Workout> = _workout

    fun getWorkout(id: Int) {
        viewModelScope.launch {
            val workout = loadWorkoutByIdUseCase(id)
            _workout.value = workout
        }
    }
}