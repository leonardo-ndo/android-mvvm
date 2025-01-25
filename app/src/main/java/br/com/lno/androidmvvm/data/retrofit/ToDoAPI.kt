package br.com.lno.androidmvvm.data.retrofit

import br.com.lno.androidmvvm.domain.model.ToDo
import retrofit2.Response
import retrofit2.http.GET

interface ToDoAPI {

    @GET("todos")
    suspend fun toDo(): Response<List<ToDo>>
}