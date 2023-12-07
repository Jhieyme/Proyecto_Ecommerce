package com.ecommerce.data

import com.ecommerce.model.CategoryItem
import com.ecommerce.model.DessertItem
import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("categories")
    var categories: ArrayList<CategoryItem> = arrayListOf(),

    @SerializedName("meals")
    var meals: ArrayList<DessertItem> = arrayListOf()

)