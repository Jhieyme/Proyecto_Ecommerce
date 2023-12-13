package com.ecommerce.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ecommerce.model.DessertEntity


@Dao
interface DessertDAO {

    @Insert()
    fun addDessertDAO(dessert: DessertEntity)

    @Query("SELECT * FROM desserts")
    fun getAllFavorites(): List<DessertEntity>
}