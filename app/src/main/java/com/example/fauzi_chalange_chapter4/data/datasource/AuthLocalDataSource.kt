package com.example.fauzi_chalange_chapter4.data.datasource

interface AuthLocalDataSource {
    fun saveToken(logtoken: String)
    fun loadToken(): String?
    fun clearToken()
}