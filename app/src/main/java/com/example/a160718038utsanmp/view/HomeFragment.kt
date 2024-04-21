package com.example.a160718038utsanmp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a160718038utsanmp.R
import com.example.a160718038utsanmp.viewmodel.ListContentModel


class HomeFragment : Fragment() {

    private val contentViewModel : ListContentModel by viewModels()
    private val contentAdapter = ContentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):View? {
        return inflater.inflate(R.layout.fragment_home,container,false)


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recyclerViewContent).apply {
            adapter = contentAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        contentViewModel.contents.observe(viewLifecycleOwner) { contents ->
            Log.d("ObserveViewModel.contents", "size: ${contents.size}")
            contentAdapter.updateData(contents)
        }

        contentViewModel.refresh()
    }



}