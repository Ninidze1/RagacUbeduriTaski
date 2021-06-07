package com.example.shemajamebeli5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli5.InputModel
import com.example.shemajamebeli5.databinding.InputItemBinding

class ResViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = mutableListOf<List<InputModel>>()

    inner class ViewHolder(private var binding: InputItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var childAdapter: ResViewAdapterSecond

        fun bind() {

            childAdapter = ResViewAdapterSecond(items[absoluteAdapterPosition].toMutableList())

            binding.secondRecycler.layoutManager = LinearLayoutManager(binding.secondRecycler.context)
            binding.secondRecycler.adapter = childAdapter



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(InputItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind()
    }

    override fun getItemCount(): Int = items.size

    fun addItems(items: MutableList<List<InputModel>>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }


}