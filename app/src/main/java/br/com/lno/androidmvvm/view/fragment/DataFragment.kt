package br.com.lno.androidmvvm.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lno.androidmvvm.databinding.FragmentDataBinding
import br.com.lno.androidmvvm.view.adapter.DataAdapter
import br.com.lno.androidmvvm.viewmodel.DataViewModel

class DataFragment : Fragment() {

    private val dataViewModel = DataViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDataBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = dataViewModel

        binding.rvData.adapter = DataAdapter(listOf())

        dataViewModel.items.observe(this, {
            (binding.rvData.adapter as DataAdapter).items = it
        })

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dataViewModel.loadItems()
    }
}