package com.example.fauzi_chalange_chapter4.data.datasource.remote

import com.example.fauzi_chalange_chapter4.data.datasource.ClubRemoteDataSource
import com.example.fauzi_chalange_chapter4.listclub.dataclass.Club

class ClubRemoteDataSourceImpl : ClubRemoteDataSource {
    override fun fetchData(): List<Club> {
        return listOf(
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/49425.png",
                nama = "Bali United",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/14107.png",
                nama = "Persija",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/20646.png",
                nama = "PSIS",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/14105.png",
                nama = "Persib",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/31444.png",
                nama = "Persebaya",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/50276.png",
                nama = "Borneo FC",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/72710.png",
                nama = "Dewa United",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/12971.png",
                nama = "Arema FC",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/14112.png",
                nama = "Persita",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/14104.png",
                nama = "PSM Makasar",
            ),
        )
    }
}