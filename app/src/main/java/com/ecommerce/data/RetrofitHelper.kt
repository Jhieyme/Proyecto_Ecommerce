package com.ecommerce.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    fun getService(): ApiInterface {
        var retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiInterface::class.java)

    }
}