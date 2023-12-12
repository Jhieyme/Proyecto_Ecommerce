package com.ecommerce.data

import androidx.room.Dao
import androidx.room.Insert
import com.ecommerce.model.DessertEntity


@Dao
interface DessertDAO {

    @Insert()
    fun addDessertDAO(dessert: DessertEntity)
}