package com.example.jsonparsetask.adapter_recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonparsetask.data_model.FieldType
import com.example.jsonparsetask.data_model.Input
import com.example.jsonparsetask.databinding.InputRvBinding

class InputAdapter: ListAdapter<Input, InputAdapter.InputViewHolder>(InputDiff()) {

    class InputDiff:DiffUtil.ItemCallback<Input>(){
        override fun areItemsTheSame(oldItem: Input, newItem: Input): Boolean {
            return oldItem.field_id == newItem.field_id
        }

        override fun areContentsTheSame(oldItem: Input, newItem: Input): Boolean {
            return oldItem == newItem
        }

    }
    inner class InputViewHolder(private val binding: InputRvBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding){
            val position = currentList[adapterPosition]
            inputEt.hint = position.hint
            
        //            when(position.field_type){
//                FieldType.INPUT.toString() -> binding.inputEt
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InputViewHolder {
       return InputViewHolder( InputRvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
       )
    }

    override fun onBindViewHolder(holder: InputViewHolder, position: Int) {
        holder.bind()
    }
}