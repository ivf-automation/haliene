package com.lilyhill.haliene

import okhttp3.MultipartBody

interface Image {
    suspend fun uploadImage(image:MultipartBody.Part):Resource<Any>
}