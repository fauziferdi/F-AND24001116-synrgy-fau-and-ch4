package com.example.fauzi_chalange_chapter4.listclub

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.room.Room
import androidx.savedstate.SavedStateRegistryOwner
import com.example.fauzi_chalange_chapter4.data.datasource.local.ClubLocalDataSourceImpl
import com.example.fauzi_chalange_chapter4.data.datasource.local.room.RoomDatabase
import com.example.fauzi_chalange_chapter4.data.datasource.remote.ClubRemoteDataSourceImpl
import com.example.fauzi_chalange_chapter4.data.domain.ClubRepository
import com.example.fauzi_chalange_chapter4.data.repository.ClubRepositoryImpl
import com.example.fauzi_chalange_chapter4.listclub.dataclass.Club


class ListClubFragmentViewModel(
    private val repository: ClubRepository,
) : ViewModel() {
    companion object {
        fun provideFactory(
            owner: SavedStateRegistryOwner,
            context: Context,
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory(owner, null) {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle,
                ): T {
                    val roomDatabase = Room.databaseBuilder(
                        context = context,
                        name = RoomDatabase.NAME,
                        klass = RoomDatabase::class.java,
                    ).build()
                    val clubRepository: ClubRepository = ClubRepositoryImpl(
                        remoteDataSource = ClubRemoteDataSourceImpl(),
                        localDataSource = ClubLocalDataSourceImpl(
                            clubDao = roomDatabase.clubDao()
                        ),
                    )
                    return ListClubFragmentViewModel(
                        repository = clubRepository,
                    )as T
                }
            }
    }

    private val _clubs : MutableLiveData<List<Club>> = MutableLiveData()
    val clubs : LiveData<List<Club>> = _clubs

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun retriveClubData(){
        _loading.value = true
        _clubs.value = repository.fetchData()
        _loading.value = false
    }

}