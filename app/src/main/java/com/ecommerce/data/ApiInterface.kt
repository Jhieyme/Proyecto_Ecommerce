package com.ecommerce.data

import com.ecommerce.model.CategoryItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("categories.php")
    fun getCategories(): Call<ApiResponse<CategoryItem>>

}