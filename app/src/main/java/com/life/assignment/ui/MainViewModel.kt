package com.life.assignment.ui

import androidx.lifecycle.*
import com.life.assignment.data.Photos
import com.life.assignment.repository.PhotosRepository
import com.life.assignment.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PhotosRepository
    ) : ViewModel() {

    val resultMutableLiveData  = MutableLiveData<Result<List<Photos>>>()


    fun getSelectMovie()  {
        viewModelScope.launch {
            resultMutableLiveData.postValue(repository.fetchPhotos())
        }
    }

    suspend fun getFetchPhoto(){
        //resultMutableLiveData.value = repository.fetchPhotos()
    }

}
