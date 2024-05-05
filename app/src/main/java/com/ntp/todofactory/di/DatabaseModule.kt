package com.ntp.todofactory.di

import android.content.Context
import androidx.room.Room
import com.ntp.todofactory.data.ToDoDatabase
import com.ntp.todofactory.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    // provide database instance
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DATABASE_NAME
    ).build()

    // provide dao instance
    @Singleton
    @Provides
    fun provideDao(database: ToDoDatabase) = database.toDoDao()
}