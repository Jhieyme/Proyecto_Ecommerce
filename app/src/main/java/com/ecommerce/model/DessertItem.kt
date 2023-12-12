package com.ecommerce.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DessertItem(
    @SerializedName("idMeal") var idMeal: String? = null,
    @SerializedName("strMeal") var strMeal: String? = null,
    @SerializedName("strMealThumb") var strMealThumb : String? = null
) : Serializable