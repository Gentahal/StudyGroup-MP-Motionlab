package com.example.jcmotion.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_locations")
data class FavoriteLocation(
    @PrimaryKey val id: String, // Misalnya, nama kota atau ID lokasi
    val name: String, // Nama lokasi
    val temperature: Double? // Suhu saat ini (opsional)
)