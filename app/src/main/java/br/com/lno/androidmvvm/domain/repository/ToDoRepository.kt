package br.com.lno.androidmvvm.domain.repository

import br.com.lno.androidmvvm.domain.model.ToDo

interface ToDoRepository {
    suspend fun getToDos(): List<ToDo>
}