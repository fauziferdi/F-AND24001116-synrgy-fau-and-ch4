package com.example.fauzi_chalange_chapter3.listclub.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fauzi_chalange_chapter3.databinding.ClubListBinding
import com.example.fauzi_chalange_chapter3.databinding.PemainListBinding
import com.example.fauzi_chalange_chapter3.listclub.adapter.adapterclub.ClubAdapterListener
import com.example.fauzi_chalange_chapter3.listclub.adapter.adapterpemain.PemainAdapterListener
import com.example.fauzi_chalange_chapter3.listclub.data.Club
import com.example.fauzi_chalange_chapter3.listclub.data.Pemain

class PemainViewHolder(
    private val pemainViewBinding: PemainListBinding,
    private val pemainAdapterListener: PemainAdapterListener,
) : RecyclerView.ViewHolder(pemainViewBinding.root) {

    fun bind(data: Pemain) {
        pemainViewBinding.namaPemain.text =data.nama
        pemainViewBinding.imgPemain.load(data.img)
        pemainViewBinding.posisiPemain.text =data.posisi
        pemainViewBinding.kewarganegaraan.text =data.negara
        pemainViewBinding.root.setOnClickListener { pemainAdapterListener.onClickPemain(data) }
    }

}