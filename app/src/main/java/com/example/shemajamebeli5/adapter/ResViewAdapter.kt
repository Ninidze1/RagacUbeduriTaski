package com.example.shemajamebeli5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli5.InputModel
import com.example.shemajamebeli5.databinding.InputItemBinding
import kotlin.coroutines.coroutineContext

class ResViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = mutableListOf<InputModel>()
    inner class ViewHolder(private var binding: InputItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var SecondList: ResViewAdapterSecond
        fun bind() {
            SecondList = ResViewAdapterSecond()
            binding.secondRecycler.layoutManager = LinearLayoutManager(itemView.context)
            binding.secondRecycler.adapter = SecondList
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(InputItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind()
    }

    override fun getItemCount(): Int = items.size

    fun addItems(items: MutableList<InputModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()

    }

}