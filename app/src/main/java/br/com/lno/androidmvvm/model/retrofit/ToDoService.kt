package br.com.lno.androidmvvm.model.retrofit

object ToDoService {

    private val toDoApi = RetrofitConfig.retrofit.create(ToDoAPI::class.java)

    suspend fun getToDos() = toDoApi.toDo()

}