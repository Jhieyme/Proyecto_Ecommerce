package com.ecommerce.database

import android.content.Context
import androidx.room.Room

object HandlerDB {
    fun getInstance(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            "favoritos_db"
        )
            .allowMainThreadQueries().build()
    }
}