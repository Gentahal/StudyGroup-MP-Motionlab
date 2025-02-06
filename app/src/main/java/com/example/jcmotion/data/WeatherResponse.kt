package com.example.jcmotion.data

data class WeatherResponse(
    val name: String, // Nama kota
    val main: MainData // Data cuaca utama
)

data class MainData(
    val temp: Double // Suhu saat ini
)
