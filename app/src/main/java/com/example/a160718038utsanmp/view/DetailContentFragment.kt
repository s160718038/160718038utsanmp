package com.example.a160718038utsanmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.a160718038utsanmp.R
import com.example.a160718038utsanmp.viewmodel.ListContentModel

class DetailContentFragment : Fragment() {


    private lateinit var viewModel: ListContentModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val txtJudulDetail = view.findViewById<TextView>(R.id.txtJudulH)
        val txtUsernameDetail = view.findViewById<TextView>(R.id.txtUsername)
        val txtDesDetail = view.findViewById<TextView>(R.id.txtDesH)


    }


}