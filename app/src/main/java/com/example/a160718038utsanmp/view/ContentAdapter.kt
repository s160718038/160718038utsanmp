package com.example.a160718038utsanmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a160718038utsanmp.R
import com.example.a160718038utsanmp.model.Content
import com.squareup.picasso.Picasso

class ContentAdapter (
    private val contents: MutableList<Content> = mutableListOf(),
    ): RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    class ViewHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view) {
        val imageview : ImageView
        val textjudul: TextView
        val textUsername: TextView
        val textDes: TextView

        init {
            imageview = view.findViewById(R.id.imageBg)
            textjudul = view.findViewById(R.id.txtJudulH)
            textUsername = view.findViewById(R.id.txtUsernameH)
            textDes = view.findViewById(R.id.txtDesH)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_content, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = contents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            val content = contents[position]
            Picasso.get().load(content.image).into(imageview)
            textjudul.text =
               content.judul
            textUsername.text =
                content.username
            textDes.text =
                content.des
        }
    }

    fun updateData(data: List<Content>) {
        contents.clear()
        contents.addAll(data)
        notifyDataSetChanged()
    }
}