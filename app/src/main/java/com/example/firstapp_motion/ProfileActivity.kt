package com.example.firstapp_motion

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil username dari intent
        val usernameProfile = findViewById<TextView>(R.id.username)
        val username = intent.getStringExtra("USERNAME")

        if (username != null) {
            usernameProfile.text = "$username"
        } else {
            usernameProfile.text = "Username tidak ditemukan."
            Log.e(TAG, "username tidak ditemukan")
        }

        val btnLogout = findViewById<TextView>(R.id.logout_button)
        btnLogout.setOnClickListener {
            val sharedPreferences: SharedPreferences =
                getSharedPreferences("USER_SESSION", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            Toast.makeText(this, "Anda berhasil logout", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Hapus sesi
            startActivity(intent)
        }

        val btnBack = findViewById<ImageView>(R.id.back_button)
        btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("USERNAME", username) // Kirim kembali username ke HomeActivity
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.navigation_profile
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("USERNAME", username) // Kirim username ke HomeActivity
                    startActivity(intent)
                    true
                }

                R.id.navigation_search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    intent.putExtra("USERNAME", username) // Kirim username ke HomeActivity
                    startActivity(intent)
                    true
                }

                R.id.navigation_profile -> true
                else -> false
            }
        }
    }
}
