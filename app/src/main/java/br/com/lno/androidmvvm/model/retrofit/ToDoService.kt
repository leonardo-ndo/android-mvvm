package br.com.lno.androidmvvm.model.retrofit

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ToDoService {

    private val toDoApi = RetrofitConfig.retrofit.create(ToDoAPI::class.java)

    /**
     * Gets the To Do list from the api.
     *
     * withContext is needed to make sure the execution will be moved to the UI thread when called.
     */
    suspend fun getToDos() = withContext(Dispatchers.IO) {
        toDoApi.toDo()
    }
}