package br.com.lno.androidmvvm.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lno.androidmvvm.R
import br.com.lno.androidmvvm.model.Data

class DataViewModel : ViewModel() {

    var reloadButtonEnabled = ObservableBoolean(false)
    var reloadButtonText = ObservableInt(R.string.loading)

    var showLoading = ObservableBoolean(true)

    var items = MutableLiveData<MutableList<Data>>()

    fun loadItems() {
        setLoading()
        val list = mutableListOf<Data>()
        for (str in 1..10000) {
            list.add(Data("String $str"))
        }
        loadItems(list)
    }

    private fun setLoading() {
        reloadButtonEnabled.set(false)
        reloadButtonText.set(R.string.loading)
        showLoading.set(true)
        items.postValue(mutableListOf())
    }

    private fun loadItems(list: MutableList<Data>) {
        items.postValue(list)
        reloadButtonEnabled.set(true)
        reloadButtonText.set(R.string.reload)
        showLoading.set(false)
    }
}