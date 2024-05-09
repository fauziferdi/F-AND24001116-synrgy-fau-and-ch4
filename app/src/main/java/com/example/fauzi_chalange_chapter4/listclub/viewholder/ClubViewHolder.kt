package com.example.fauzi_chalange_chapter4.listclub.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fauzi_chalange_chapter4.databinding.ClubListBinding
import com.example.fauzi_chalange_chapter4.listclub.adapter.ClubAdapterListener
import com.example.fauzi_chalange_chapter4.listclub.dataclass.Club

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