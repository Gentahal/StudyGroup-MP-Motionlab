package com.example.firstapp_motion

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val welcomeTextView = findViewById<TextView>(R.id.tv_welcome)
        val username = intent.getStringExtra("USERNAME") // Ambil data USERNAME dari intent

        welcomeTextView.text = "Welcome To Motion Lab, $username!"

        bottomNavigationView.selectedItemId = R.id.navigation_home

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    true
                }

                R.id.navigation_search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    intent.putExtra("USERNAME", username)
                    startActivity(intent)
                    true
                }

                R.id.navigation_profile -> {
                    // Pindah ke ProfileActivity sambil mengirim data USERNAME
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("USERNAME", username)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }
}
