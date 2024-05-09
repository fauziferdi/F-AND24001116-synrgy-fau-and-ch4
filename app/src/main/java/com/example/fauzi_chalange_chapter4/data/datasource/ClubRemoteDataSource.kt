package com.example.fauzi_chalange_chapter4.data.datasource

import com.example.fauzi_chalange_chapter4.listclub.dataclass.Club

interface ClubRemoteDataSource {
    fun fetchData(): List<Club>
}