package br.com.lno.androidmvvm.data.retrofit

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToDoService @Inject constructor(private val toDoApi: ToDoAPI) {

    /**
     * Gets the To Do list from the api.
     *
     * withContext is needed to make sure the execution will be moved to the UI thread when called.
     */
    suspend fun getToDos() = withContext(Dispatchers.IO) {
        toDoApi.toDo()
    }
}