package com.lilyhill.haliene

import retrofit2.http.GET
import retrofit2.Call


public interface UploadImageService {
    @GET("/albums")
    fun getCountries() : Call<List<ImageApi>>

    @GET("country/get/all")
    fun getName() : Call<ImageApi>
}