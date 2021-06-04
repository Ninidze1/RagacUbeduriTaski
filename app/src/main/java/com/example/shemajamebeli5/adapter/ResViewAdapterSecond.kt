package com.example.shemajamebeli5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli5.InputModel
import com.example.shemajamebeli5.databinding.InputSecondItemBinding
import com.example.shemajamebeli5.databinding.InputSecondItemChooseBinding

class ResViewAdapterSecond: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = mutableListOf<InputModel>()

    inner class ViewHolderEditText(private var binding: InputSecondItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {

        }
    }

    inner class ViewHolderChoosed(private var binding: InputSecondItemChooseBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1)
            ViewHolderEditText(
                InputSecondItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        else
            ViewHolderChoosed(
                InputSecondItemChooseBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderEditText -> holder.bind()
            is ViewHolderChoosed -> holder.bind()
        }
        (holder as ViewHolderEditText).bind()
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        val model = items[position]
        return if (model.fieldType == "chooser")
            2
        else
            1
    }

    fun addItems(items: MutableList<InputModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()

    }

}