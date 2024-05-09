package com.example.fauzi_chalange_chapter4.login

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.savedstate.SavedStateRegistryOwner
import com.example.fauzi_chalange_chapter4.data.datasource.local.AuthLocalDataSourceImpl
import com.example.fauzi_chalange_chapter4.data.datasource.local.SharedPreferenceFactory
import com.example.fauzi_chalange_chapter4.data.datasource.remote.AuthRemoteDataSourceImpl
import com.example.fauzi_chalange_chapter4.data.domain.AuthRepository
import com.example.fauzi_chalange_chapter4.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.launch

class LoginViewModel (
    private val authRepository: AuthRepository,
) : ViewModel() {

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
                    return LoginViewModel(authRepository = authRepository) as T
                }
            }
    }

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                _loading.value = true
                val logtoken = authRepository.login(username, password)
                authRepository.saveToken(logtoken)
                _loading.value = false
                _success.value = true
            } catch (throwable: Throwable){
                _loading.value = false
                _error.value = throwable.message
            }
        }
    }


}