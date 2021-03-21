package br.com.lno.androidmvvm.model.retrofit

class ToDoService {

    private val toDoApi: ToDoAPI = RetrofitConfig.retrofit.create(ToDoAPI::class.java)

    suspend fun getToDos() = toDoApi.toDo()

}