package com.example.fauzi_chalange_chapter3.listclub.adapter.adapterpemain
import androidx.recyclerview.widget.DiffUtil
import com.example.fauzi_chalange_chapter3.listclub.data.Club
import com.example.fauzi_chalange_chapter3.listclub.data.Pemain

class PemainDiffUtil : DiffUtil.ItemCallback<Pemain>() {
    override fun areItemsTheSame(oldItem: Pemain, newItem: Pemain): Boolean {
        return oldItem.nama == newItem.nama
    }
    override fun areContentsTheSame(oldItem: Pemain, newItem: Pemain): Boolean {
        return oldItem.nama == newItem.nama
    }
}