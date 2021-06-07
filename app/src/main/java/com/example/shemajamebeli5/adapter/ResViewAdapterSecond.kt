package com.example.shemajamebeli5.adapter

import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli5.InputModel
import com.example.shemajamebeli5.R
import com.example.shemajamebeli5.databinding.InputSecondItemBinding
import com.example.shemajamebeli5.databinding.InputSecondItemChooseBinding

class ResViewAdapterSecond(private val fields: List<InputModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolderEditText(private var binding: InputSecondItemBinding) : RecyclerView.ViewHolder(binding.root) {

        var inputMap: MutableMap<Int ,String> = mutableMapOf()

        fun bind() {

            val input = fields[absoluteAdapterPosition]

            binding.editText.id = input.id
            binding.editText.hint = input.hint


            when (input.keyboard) {
                "number" -> binding.editText.inputType = InputType.TYPE_CLASS_NUMBER
                "text" -> binding.editText.inputType = InputType.TYPE_CLASS_TEXT
            }

            binding.editText.addTextChangedListener (object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    d("loglog", "$s, ${binding.editText.hint}")
                    inputMap[binding.editText.id] = s.toString()
                }

                override fun afterTextChanged(s: Editable?) {
                }

            })
            d("tagtag", "$inputMap")
        }
    }

    inner class ViewHolderChoosed(private var binding: InputSecondItemChooseBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {

            ArrayAdapter.createFromResource(
                binding.spinner.context, R.array.gender, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinner.adapter = adapter
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                ViewHolderEditText(
                    InputSecondItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                ViewHolderChoosed(
                    InputSecondItemChooseBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderEditText -> holder.bind()
            is ViewHolderChoosed -> holder.bind()
        }
    }

    override fun getItemCount(): Int = fields.size


    override fun getItemViewType(position: Int): Int {
        val model = fields[position]
        return when (model.fieldType) {
            "chooser" -> 2
            else -> 1
        }
    }
}