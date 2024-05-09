package com.example.fauzi_chalange_chapter4.listclub.adapter
import com.example.fauzi_chalange_chapter4.listclub.dataclass.Club

interface ClubAdapterListener {
    fun onClickClub(data: Club)
}