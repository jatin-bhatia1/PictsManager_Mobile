package com.example.pictsmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)

        button.setOnClickListener {
            if(editTextUserName.text.toString() == "admin" && editTextTextPassword.text.toString() == "admin" ){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Wrong username or password !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
