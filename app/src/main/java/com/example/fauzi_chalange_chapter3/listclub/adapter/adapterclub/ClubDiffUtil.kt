package com.example.fauzi_chalange_chapter3.listclub.adapter.adapterclub
import androidx.recyclerview.widget.DiffUtil
import com.example.fauzi_chalange_chapter3.listclub.data.Club

class ClubDiffUtil : DiffUtil.ItemCallback<Club>() {
    override fun areItemsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem.nama == newItem.nama
    }
    override fun areContentsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem.nama == newItem.nama
    }
}