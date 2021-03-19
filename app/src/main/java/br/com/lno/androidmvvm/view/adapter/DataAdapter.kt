package br.com.lno.androidmvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lno.androidmvvm.databinding.ItemDataBinding
import br.com.lno.androidmvvm.model.Data

class DataAdapter(items: List<Data>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    var items = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDataBinding.inflate(
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

    class ViewHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data) {
            binding.data = item
            binding.executePendingBindings()
        }
    }
}