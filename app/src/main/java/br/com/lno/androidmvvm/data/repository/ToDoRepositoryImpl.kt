package br.com.lno.androidmvvm.data.repository

import br.com.lno.androidmvvm.data.retrofit.ToDoService
import br.com.lno.androidmvvm.domain.model.ToDo
import br.com.lno.androidmvvm.domain.repository.ToDoRepository
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(private val toDoService: ToDoService) :
    ToDoRepository {

    override suspend fun getToDos(): List<ToDo> {
        return toDoService.getToDos().body() ?: emptyList()
    }
}