package com.example.fauzi_chalange_chapter4.data.datasource.remote

import com.example.fauzi_chalange_chapter4.data.datasource.AuthRemoteDataSource
import com.example.fauzi_chalange_chapter4.data.model.User
import kotlinx.coroutines.delay

class AuthRemoteDataSourceImpl : AuthRemoteDataSource {
    private val users
        get() = listOf(
            User(
                username = "fauzi",
                password = "12345"
            ),
        )

    override suspend fun login(username: String, password: String): String {
        delay(1000)
        if(users.contains(User(username,password))){
            return "dashdy23622g2ysy2w27s288s282"
        }else{
            throw UnsupportedOperationException("User Kosong")
        }
    }
}