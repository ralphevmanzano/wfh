package com.ralphevmanzano.workoutsforhumans.core.di

import android.content.Context
import androidx.room.Room
import com.ralphevmanzano.workoutsforhumans.core.data.local.WorkoutDatabase
import com.ralphevmanzano.workoutsforhumans.core.data.local.dao.WorkoutDao
import com.ralphevmanzano.workoutsforhumans.core.data.local.datasource.WorkoutLocalDataSourceImpl
import com.ralphevmanzano.workoutsforhumans.core.data.WorkoutRepositoryImpl
import com.ralphevmanzano.workoutsforhumans.core.domain.datasource.WorkoutLocalDataSource
import com.ralphevmanzano.workoutsforhumans.core.domain.repository.WorkoutRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WorkoutSingletonModule {

    private companion object {
        private const val WORKOUT_DB = "workout.db"
        private const val DB_ASSET_PATH = "db/workouts.db"
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): WorkoutDatabase {
        return Room.databaseBuilder(
            context,
            WorkoutDatabase::class.java,
            WORKOUT_DB
        ).createFromAsset(DB_ASSET_PATH).build()
    }

    @Provides
    @Singleton
    fun provideWorkoutDao(workoutDatabase: WorkoutDatabase) = workoutDatabase.workoutDao()

    @Provides
    @Singleton
    fun provideWorkoutLocalDataSource(
        workoutDao: WorkoutDao,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): WorkoutLocalDataSource {
        return WorkoutLocalDataSourceImpl(workoutDao, dispatcher)
    }

    @Provides
    @Singleton
    fun provideWorkoutRepository(
        localDataSource: WorkoutLocalDataSource
    ): WorkoutRepository {
        return WorkoutRepositoryImpl(localDataSource)
    }
}