package com.lilyhill.haliene

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.Body


public interface UploadImageService {
    @GET("/albums")
    fun getCountries() : Call<List<ImageApi>>

    @GET("country/get/all")
    fun getName() : Call<ImageApi>

    @POST("/posts")
    fun putName(@Body userinfo: UserInfo) : Call<ImageApiResponse>
}