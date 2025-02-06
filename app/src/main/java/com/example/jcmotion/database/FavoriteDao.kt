package com.example.jcmotion.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jcmotion.data.FavoriteLocation

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // Menangani duplikasi
    suspend fun addFavorite(favorite: FavoriteLocation)

    @Delete
    suspend fun removeFavorite(favorite: FavoriteLocation)

    @Query("SELECT * FROM favorite_locations")
    suspend fun getAllFavorites(): List<FavoriteLocation>
}