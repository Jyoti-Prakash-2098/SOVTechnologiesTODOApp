package com.example.sovtechnologies.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sovtechnologies.R
import com.example.sovtechnologies.databinding.FragmentTodoBinding
import com.example.sovtechnologies.ui.db.Tasks
import com.example.sovtechnologies.ui.db.TasksDatabase
import com.example.sovtechnologies.ui.recyclerviewadapter.TodoRecyclerViewAdapter
import com.example.sovtechnologies.ui.viewmodel.TodoViewModel
import com.example.sovtechnologies.ui.viewmodelfactory.TodoViewModelFactory


class TodoFragment : Fragment() {
    private var binding: FragmentTodoBinding? = null
    private var viewModel: TodoViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            requireActivity(),
            TodoViewModelFactory(TasksDatabase(requireContext()))
        )[TodoViewModel::class.java]
        return binding!!.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val list = arrayListOf<Tasks>()
        val todoAdapter = TodoRecyclerViewAdapter(list)
        viewModel?.getTasks()?.observe(requireActivity()) {
            list.addAll(it)
            todoAdapter.notifyDataSetChanged()
        }
        binding?.recyclerViewTodoList?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = todoAdapter
        }
    }
}