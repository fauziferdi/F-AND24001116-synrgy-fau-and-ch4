package com.example.fauzi_chalange_chapter4.data.domain
import com.example.fauzi_chalange_chapter4.listclub.dataclass.Club

interface ClubRepository {

    fun fetchData(): List<Club>

    fun storeData(data: Club)

    suspend fun saveFavorite(club: Club)

    suspend fun loadAllClub(): List<Club>

    suspend fun deleteClub(club: Club)

    suspend fun loadClubById(id: Int): Club?
}