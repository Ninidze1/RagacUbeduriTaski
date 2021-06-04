package com.example.shemajamebeli5.fragments

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli5.adapter.ResViewAdapter
import com.example.shemajamebeli5.databinding.MainFragmentBinding

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

        viewModel.init()
        adapterInit()
        observers()

    }

    private fun adapterInit() {

        adapter = ResViewAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

    }

    private fun observers() {

        viewModel._inputLiveData.observe(viewLifecycleOwner, {
            d("tagtag", "$it")
            adapter.addItems(it.toMutableList())
        })
    }

}