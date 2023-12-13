package com.ecommerce.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "desserts")
data class DessertEntity(
    @PrimaryKey
    val id: String,
    val nameDessert: String?,
    val urlImageDessert: String?
) {

}