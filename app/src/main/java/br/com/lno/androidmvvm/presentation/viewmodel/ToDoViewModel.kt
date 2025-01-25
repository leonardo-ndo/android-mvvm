package br.com.lno.androidmvvm.presentation.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lno.androidmvvm.R
import br.com.lno.androidmvvm.domain.model.ToDo
import br.com.lno.androidmvvm.domain.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val toDoRepository: ToDoRepository
) : ViewModel() {

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
            try {
                items.postValue(toDoRepository.getToDos())
            } catch (e: Exception) {
                Toast.makeText(context, R.string.error, Toast.LENGTH_LONG).show()
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