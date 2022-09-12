package com.lilyhill.haliene
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.Part
import retrofit2.http.POST
import com.lilyhill.haliene.Image
import android.util.Log
import okhttp3.Response

data class uploadImageResponse(
    val message: String? = null,
    val successful: Boolean = false,
)

interface ImageApi {
    @Multipart
    @POST("/preprocess/upload/")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part,
    ):Response
}
