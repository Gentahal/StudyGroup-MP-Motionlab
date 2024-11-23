package com.example.firstapp_motion

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) //connect to ui xml
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usernameEditText = findViewById<TextInputLayout>(R.id.til_username)
        val passwordEditText = findViewById<TextInputLayout>(R.id.til_password)

        val login = findViewById<Button>(R.id.btn_login)

        login.setOnClickListener {
            val username = usernameEditText.editText?.text.toString()
            val password = passwordEditText.editText?.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username atau Password harus di isi", Toast.LENGTH_SHORT)
                    .show()
                Log.e(TAG, "login gagal")
            } else {
                Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()

                // Simpan sesi login di SharedPreferences
                val sharedPreferences: SharedPreferences = getSharedPreferences("USER_SESSION", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("USERNAME", username)
                editor.apply()

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(
                    intent
                )

            }

        }
    }
}