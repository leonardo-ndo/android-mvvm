package br.com.lno.androidmvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lno.androidmvvm.databinding.ItemTodoBinding
import br.com.lno.androidmvvm.model.ToDo

class ToDoAdapter(items: List<ToDo>) : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    var items = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ToDo) {
            binding.toDo = item
            binding.executePendingBindings()
        }
    }
}