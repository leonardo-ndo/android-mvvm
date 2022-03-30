package br.com.lno.androidmvvm.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.lno.androidmvvm.databinding.FragmentDataBinding
import br.com.lno.androidmvvm.view.adapter.ToDoAdapter
import br.com.lno.androidmvvm.viewmodel.ToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoFragment : Fragment() {

    private val dataViewModel by viewModels<ToDoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDataBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = dataViewModel

        val toDoAdapter = ToDoAdapter()

        binding.rvData.adapter = toDoAdapter
        binding.rvData.addItemDecoration(
            DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        )

        dataViewModel.items.observe(viewLifecycleOwner) {
            toDoAdapter.submitList(it)
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataViewModel.loadItems()
    }
}