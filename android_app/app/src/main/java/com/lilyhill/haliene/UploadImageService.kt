package com.lilyhill.haliene

import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Part


public interface UploadImageService {
    @GET("/albums")
    fun getCountries() : Call<List<ImageApi>>

    @GET("country/get/all")
    fun getName() : Call<ImageApi>

    @POST("preprocess/upload_test/")
    fun putName(@Body userinfo: UserInfo) : Call<ImageApiResponse>

    @POST("preprocess/upload_test/")
    fun putImage(@Body userinfo: UserInfo, @Part image: MultipartBody.Part) : Call<ImageApiResponse>
}