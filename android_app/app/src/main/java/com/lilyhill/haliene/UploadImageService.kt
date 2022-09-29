package com.lilyhill.haliene

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*


public interface UploadImageService {
    @GET("/albums")
    fun getCountries() : Call<List<ImageApi>>

    @GET("country/get/all")
    fun getName() : Call<ImageApi>

    @POST("preprocess/upload_test/")
    fun putName(@Body userinfo: UserInfo) : Call<ImageApiResponse>

    @Multipart
    @POST("preprocess/upload_test/")
    fun putImage( @Part multipartUserID: MultipartBody.Part, @Part multipartUserName: MultipartBody.Part, @Part multipartUserEmail: MultipartBody.Part, @Part multipartUserAge: MultipartBody.Part, @Part image: MultipartBody.Part) : Call<ImageApiResponse>
}