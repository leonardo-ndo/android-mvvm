package br.com.lno.androidmvvm.di

import br.com.lno.androidmvvm.data.repository.ToDoRepositoryImpl
import br.com.lno.androidmvvm.domain.repository.ToDoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        fun bindToDoRepository(repository: ToDoRepositoryImpl): ToDoRepository
    }
}