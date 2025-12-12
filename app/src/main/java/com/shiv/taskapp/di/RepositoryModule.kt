package com.shiv.taskapp.di

import com.shiv.taskapp.data.TaskRepositoryImpl
import com.shiv.taskapp.domain.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideTaskRepository(
        impl: TaskRepositoryImpl
    ): TaskRepository
}