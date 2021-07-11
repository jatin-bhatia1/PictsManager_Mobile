package com.example.pictsmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pictsmanager.api.ApiClient
import com.example.pictsmanager.models.Album
import com.example.pictsmanager.models.User
import com.example.pictsmanager.viewmodels.PostLoginUserViewModel
import kotlinx.android.synthetic.main.login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)

        button.setOnClickListener {
            val username = editTextUserName.text.toString()
            val password = editTextTextPassword.text.toString()
            if (username != "" && password != "") {
                var user: User? = null
                val loginResponse =
                    ApiClient.apiService.postLogin(PostLoginUserViewModel(username, password))
                loginResponse.enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        user = response.body()
                        if (user != null) {
                            val intent = Intent(this@Login, MainActivity::class.java)
                            intent.putExtra("user_id", user!!.id)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Toast.makeText(
                            this@Login,
                            "Wrong Username or Password !",
                            Toast.LENGTH_LONG
                        ).show()
                        t.message?.let { Log.e("ERROR:", it) }
                    }
                })
            } else {
                Toast.makeText(this, "Username or password can't be blank !", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
