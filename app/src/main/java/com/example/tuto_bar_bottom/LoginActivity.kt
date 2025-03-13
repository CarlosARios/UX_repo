package com.example.tuto_bar_bottom

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val button = findViewById<Button>(R.id.button_login)
        val usernameEditText = findViewById<EditText>(R.id.editText_login)
        val passwordEditText = findViewById<EditText>(R.id.TextPassword_login)

        button.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val username = usernameEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()
                button.isEnabled = username.isNotEmpty() && password.isNotEmpty()
            }

            override fun afterTextChanged(s: Editable?) {}
        }

        usernameEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)

        val goto = Intent(this, MainActivity::class.java)
        button.setOnClickListener {
            startActivity(goto)
        }
    }
}