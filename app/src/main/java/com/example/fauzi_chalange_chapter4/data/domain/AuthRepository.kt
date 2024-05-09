package com.example.fauzi_chalange_chapter4.data.domain

interface AuthRepository {
   suspend fun login(username: String, password: String): String
   fun saveToken(logtoken: String)
   fun loadToken(): String?
   fun clearToken()
}