package com.example.fauzi_chalange_chapter3.listclub.adapter.adapterclub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.fauzi_chalange_chapter3.databinding.ClubListBinding
import com.example.fauzi_chalange_chapter3.listclub.data.Club
import com.example.fauzi_chalange_chapter3.listclub.viewholder.ClubViewHolder


class ClubAdapter(private val clubAdapterListener: ClubAdapterListener,
    ) : ListAdapter<Club, ClubViewHolder>(ClubDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(
            clubViewBinding = ClubListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            clubAdapterListener = clubAdapterListener,
        )
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    }
