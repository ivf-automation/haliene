package com.lilyhill.haliene.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.File

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    fun uploadImage(file: File){
        viewModelScope.launch {

        }
    }
}