package com.ecommerce.model

import com.google.gson.annotations.SerializedName

data class CategoryItem(
    @SerializedName("idCategory") var idCategory: String? = null,
    @SerializedName("strCategory") var strCategory: String? = null,
    @SerializedName("strCategoryThumb") var strCategoryThumb: String? = null,
    @SerializedName("strCategoryDescription") var strCategoryDescription: String? = null
)