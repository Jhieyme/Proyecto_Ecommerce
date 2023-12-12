package com.ecommerce.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ecommerce.data.DessertDAO
import com.ecommerce.model.DessertEntity


@Database(entities = [DessertEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun dessertDAO(): DessertDAO
}