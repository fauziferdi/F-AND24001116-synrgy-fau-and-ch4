package com.example.fauzi_chalange_chapter4.data.repository

import com.example.fauzi_chalange_chapter4.data.datasource.AuthLocalDataSource
import com.example.fauzi_chalange_chapter4.data.datasource.AuthRemoteDataSource
import com.example.fauzi_chalange_chapter4.data.domain.AuthRepository

class AuthRepositoryImpl (
    private val authLocalDataSource: AuthLocalDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource,

    ): AuthRepository {

    override suspend fun login(username: String, password: String): String {
        return authRemoteDataSource.login(username,password)
    }

    override fun saveToken(logtoken: String) {
        authLocalDataSource.saveToken(logtoken)
    }

    override fun loadToken(): String? {
        return authLocalDataSource.loadToken()
    }

    override fun clearToken() {
        authLocalDataSource.clearToken()
    }
}