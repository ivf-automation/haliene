package com.lilyhill.haliene
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.Part
import retrofit2.http.POST

data class uploadImageResponse(
    val message: String? = null,
    val successful: Boolean = false,
)

@Multipart
@POST("/preprocess/upload/")
suspend fun uploadImage (
    @Part image: MultipartBody.Part,
) {
}

