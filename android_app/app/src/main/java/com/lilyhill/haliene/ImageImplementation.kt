package com.lilyhill.haliene

import android.util.Log
import okhttp3.MultipartBody

class ImageImplementation(val imageApi: ImageApi): Image {
    override suspend fun uploadImage(image: MultipartBody.Part): Resource<Any>{
        return try {
            val response = imageApi.uploadImage(image)
            val result = response.body()
            Log.d("XXXXXX", "" + result.toString())
            if (response.isSuccessful){
                Log.d("XXXXXX", "" + result.toString())
                Resource.Success(result!!)
            }
            else {
                Resource.Error(response.message())
            }
        } catch (e: Exception){
            Resource.Error(e.message?: "An error occured")
        }

    }
}
