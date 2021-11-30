package br.com.lno.androidmvvm.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lno.androidmvvm.R
import br.com.lno.androidmvvm.model.ToDo
import br.com.lno.androidmvvm.model.retrofit.ToDoService
import kotlinx.coroutines.launch

class ToDoViewModel : ViewModel() {

    var reloadButtonEnabled = ObservableBoolean(false)
    var reloadButtonText = ObservableInt(R.string.loading)

    var showLoading = ObservableBoolean(true)

    var items = MutableLiveData<List<ToDo>>()

    fun loadItems() {
        /**
         * Creates a coroutine block and run the block inside of it in the provided Dispatcher.
         * If no Dispatcher is specified, defaults to Dispatchers.Main
         */
        viewModelScope.launch {
            setLoading(true)
            val toDoResponse = ToDoService.getToDos()
            if (toDoResponse.isSuccessful) {
                items.postValue(toDoResponse.body())
            }
            setLoading(false)
        }
    }

    private fun setLoading(isLoading: Boolean) {
        reloadButtonEnabled.set(!isLoading)
        reloadButtonText.set(if (isLoading) R.string.loading else R.string.reload)
        showLoading.set(isLoading)
    }
}