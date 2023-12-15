package com.example.jsonparsetask.adapter_recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonparsetask.data_model.Input
import com.example.jsonparsetask.databinding.BackgroundRvBinding

class BackgroundAdapter:ListAdapter<Input,BackgroundAdapter.BackgroundViewHolder>(BackgroundDiff()) {

    class BackgroundDiff: DiffUtil.ItemCallback<Input>(){
        override fun areItemsTheSame(oldItem: Input, newItem: Input): Boolean {
            return oldItem.field_id == newItem.field_id
        }

        override fun areContentsTheSame(oldItem: Input, newItem: Input): Boolean {
            return oldItem == newItem
        }

    }
    inner class BackgroundViewHolder(private val binding:BackgroundRvBinding):RecyclerView.ViewHolder(binding.backgroundCardRv) {
        fun bind(){
            val position = currentList[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BackgroundViewHolder {
        return BackgroundViewHolder(
            BackgroundRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: BackgroundViewHolder, position: Int) {
        holder.bind()
    }
}
