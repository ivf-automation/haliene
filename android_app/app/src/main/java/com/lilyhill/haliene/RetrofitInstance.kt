package com.lilyhill.haliene

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import android.util.Log
import com.lilyhill.haliene.UserInfo

class RetrofitInstance {
    val retrofit: Retrofit? = null
//    val baseUrl:String = "http://localhost:8090/"
    val baseUrl:String = "https://jsonplaceholder.typicode.com"


    public fun getService(): Retrofit? {
        if (retrofit == null){
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UploadImageService::class.java)
            val retrofitData = retrofit.getCountries()

            retrofitData.enqueue(object : Callback<List<ImageApi>?> {
                override fun onResponse(call: Call<List<ImageApi>?>, response: Response<List<ImageApi>?>) {
                    val responseBody = response.body()!!
                    val myStringBuilder = StringBuilder()
                    for (data in responseBody){
                        myStringBuilder.append(data.userId)
                    }
                    Log.d("SUCCESS", myStringBuilder.toString())
                }
                override fun onFailure(call: Call<List<ImageApi>?>, response: Throwable) {
                    Log.d("FAILED", "api call failed")
                }
            })
        }
        return retrofit
    }
    public fun putService(userInfo: UserInfo): Retrofit? {
        if (retrofit == null){
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UploadImageService::class.java)
            val retrofitData = retrofit.putName(userInfo)

            retrofitData.enqueue(object : Callback<ImageApiResponse> {
                override fun onResponse(call: Call<ImageApiResponse>, response: Response<ImageApiResponse>) {
                    val responseBody = response.body()!!
                    val myStringBuilder = StringBuilder()
                    myStringBuilder.append(responseBody.id)
                    Log.d("SUCCESS", myStringBuilder.toString())
                }
                override fun onFailure(call: Call<ImageApiResponse>, response: Throwable) {
                    Log.d("FAILED", "api call failed")
                }
            })
        }
        return retrofit
    }
}