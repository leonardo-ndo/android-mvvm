package br.com.lno.androidmvvm.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.lno.androidmvvm.databinding.FragmentDataBinding
import br.com.lno.androidmvvm.view.adapter.ToDoAdapter
import br.com.lno.androidmvvm.viewmodel.ToDoViewModel

class ToDoFragment : Fragment() {

    private val dataViewModel by lazy { ToDoViewModel() }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDataBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = dataViewModel

        binding.rvData.adapter = ToDoAdapter(listOf())
        binding.rvData.addItemDecoration(
                DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        )

        dataViewModel.items.observe(viewLifecycleOwner, {
            (binding.rvData.adapter as ToDoAdapter).items = it
        })

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataViewModel.loadItems()
    }
}