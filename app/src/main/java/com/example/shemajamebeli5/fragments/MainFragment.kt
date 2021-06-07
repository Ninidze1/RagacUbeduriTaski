package com.example.shemajamebeli5.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli5.R
import com.example.shemajamebeli5.adapter.ResViewAdapter
import com.example.shemajamebeli5.adapter.ResViewAdapterSecond
import com.example.shemajamebeli5.databinding.MainFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: ResViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {

        adapterInit()
        viewModel.init()
        observers()
        check()
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                saveFields()
            }
        }
    }

    private fun adapterInit() {

        adapter = ResViewAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun saveFields()  {

    }

    private fun check() {
        binding.button.setOnClickListener {
            binding.recyclerView.children.forEach {
                it.findViewById<RecyclerView>(R.id.secondRecycler).children.forEach { fields ->
                    val inputText = fields.findViewById<EditText>(R.id.editText)
//                    if (inputText.text.toString() in )
                }
            }

        }

    }

    private fun observers() {
        viewModel._inputLiveData.observe(viewLifecycleOwner, {
            adapter.addItems(it.toMutableList())
        })
        viewModel._fieldData.observe(viewLifecycleOwner, {
            d("taglog", "$it")
        })
    }

}