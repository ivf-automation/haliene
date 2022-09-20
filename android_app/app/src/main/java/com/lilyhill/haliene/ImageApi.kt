package com.lilyhill.haliene
import com.google.gson.annotations.SerializedName
import retrofit2.http.Part

data class ImageApi (
    @SerializedName("userId" ) var userId : Int?    = null,
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("title"  ) var title  : String? = null,
)

data class ImageApiResponse (
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("message"     ) var message     : String?    = null,
)


data class UserInfo (
    @SerializedName("user_id") val userId: Int?,
    @SerializedName("user_name") val userName: String?,
    @SerializedName("user_email") val userEmail: String?,
    @SerializedName("user_age") val userAge: String?,
    @SerializedName("user_uid") val userUid: String?
)
