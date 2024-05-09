package com.example.fauzi_chalange_chapter4.navigator

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.fauzi_chalange_chapter4.data.datasource.local.AuthLocalDataSourceImpl
import com.example.fauzi_chalange_chapter4.data.datasource.local.SharedPreferenceFactory
import com.example.fauzi_chalange_chapter4.data.datasource.remote.AuthRemoteDataSourceImpl
import com.example.fauzi_chalange_chapter4.data.domain.AuthRepository
import com.example.fauzi_chalange_chapter4.data.repository.AuthRepositoryImpl

class NavigatorViewModel(private val authRepository: AuthRepository)
    : ViewModel() {
        companion object{
            fun provideFactory(
                owner: SavedStateRegistryOwner,
                context: Context,
            ) : AbstractSavedStateViewModelFactory =
                object : AbstractSavedStateViewModelFactory(owner, null) {
                    @Suppress("UNCHECKED_CAST")
                    override fun <T : ViewModel> create(
                        key: String,
                        modelClass: Class<T>,
                        handle: SavedStateHandle,
                    ): T {
                        val authRepository: AuthRepository = AuthRepositoryImpl(
                            authLocalDataSource = AuthLocalDataSourceImpl(
                                sharedPreferences = SharedPreferenceFactory().createSharedPreference(context),
                            ),
                            authRemoteDataSource = AuthRemoteDataSourceImpl(),
                        )
                        return NavigatorViewModel(authRepository=authRepository) as T
                    }
                }
        }

    fun checkLogin():Boolean{
        return !authRepository.loadToken().isNullOrEmpty()
    }
}