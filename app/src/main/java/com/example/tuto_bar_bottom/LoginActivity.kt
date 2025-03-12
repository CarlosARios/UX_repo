package com.example.tuto_bar_bottom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val button = findViewById<Button>(R.id.button_cr)
        val goto = Intent(this, MainActivity::class.java)
        button.setOnClickListener {
            startActivity(goto)
        }


    }
}