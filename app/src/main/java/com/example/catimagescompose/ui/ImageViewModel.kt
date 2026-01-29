package com.example.catimagescompose.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catimagescompose.data.ImageDataModel
import com.example.catimagescompose.data.ImageDataRepository
import kotlinx.coroutines.launch


class ImageViewModel (private val repository: ImageDataRepository) : ViewModel() {

    private val _data = MutableLiveData<List<ImageDataModel>>()
    val data: LiveData<List<ImageDataModel>> get() = _data

    fun loadData() {
        viewModelScope.launch {
            val fetchedData = repository.fetchData()
            _data.postValue(fetchedData)
        }
    }
}