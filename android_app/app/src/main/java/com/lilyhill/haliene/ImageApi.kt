package com.lilyhill.haliene
import com.google.gson.annotations.SerializedName

data class ImageApi (
    @SerializedName("userId" ) var userId : Int?    = null,
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("title"  ) var title  : String? = null
)