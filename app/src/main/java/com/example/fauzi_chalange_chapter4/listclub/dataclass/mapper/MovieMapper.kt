package com.example.fauzi_chalange_chapter4.listclub.dataclass.mapper

import com.example.fauzi_chalange_chapter4.data.datasource.local.room.ClubEntity
import com.example.fauzi_chalange_chapter4.listclub.dataclass.Club

fun Club.toClubEntity(): ClubEntity {
    return ClubEntity(
        nama = nama,
        image = image,
        id = id,
    )
}

fun ClubEntity.toClub(): Club {
    return Club(
        nama = nama,
        image = image,
        id = id,
    )
}

fun List<ClubEntity>.toClub(): List<Club> {
    return map { clubEntity -> clubEntity.toClub() }
}