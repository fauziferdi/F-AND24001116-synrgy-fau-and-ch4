package com.example.fauzi_chalange_chapter3.listclub.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fauzi_chalange_chapter3.databinding.ClubListBinding
import com.example.fauzi_chalange_chapter3.listclub.adapter.adapterclub.ClubAdapterListener
import com.example.fauzi_chalange_chapter3.listclub.data.Club

class ClubViewHolder(
    private val clubViewBinding: ClubListBinding,
    private val clubAdapterListener: ClubAdapterListener,
) : RecyclerView.ViewHolder(clubViewBinding.root) {

    fun bind(data: Club) {
        clubViewBinding.textTitle.text = data.nama
        clubViewBinding.imagePoster.load(data.image)
        clubViewBinding.root.setOnClickListener { clubAdapterListener.onClickClub(data) }
    }

}