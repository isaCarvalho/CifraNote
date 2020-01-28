package com.example.cifranote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val myDataset: Array<String>): RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    class MyViewHolder (val v: View) : RecyclerView.ViewHolder(v)
    {
        val textView: TextView = v.findViewById(R.id.musicName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myDataset.get(position)
    }

    override fun getItemCount(): Int = myDataset.size
}