package com.lilyhill.haliene.ui.main

import com.lilyhill.haliene.MainEvent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lilyhill.haliene.ImageImplementation
import kotlinx.coroutines.launch
import java.io.File
import retrofit2.http.RetrofitInstance

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val imageFile_ = MutableLiveData<File>()
        val imageFile: LiveData<File>
            get() = imageFile_

    private val mainEvent_ = MutableLiveData<MainEvent>()
    val mainEvent: LiveData<MainEvent>
        get() = mainEvent_

    var image: Image? = null
    var imageApi: ImageAPI? = null

    init {
        imageApi = RetrofitInstance.getRetrofitInstance().create(ImageAPI::class.java)
        image = ImageImplementation(imageApi!!)
    }

    fun uploadImage(file: File){
        viewModelScope.launch {

        }
    }
}