package com.example.a160718038utsanmp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160718038utsanmp.R

class LoginActivity : AppCompatActivity() {

    private lateinit var txtUsername: EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var textViewCreateAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnRegis)
        textViewCreateAccount = findViewById(R.id.textView4)

        btnLogin.setOnClickListener {
            loginUser()
        }

        textViewCreateAccount.setOnClickListener {
            // Redirect to registration activity
            startActivity(Intent(this, RegistrasiActivity::class.java))
        }
    }

    private fun loginUser() {
        val queue = Volley.newRequestQueue(this)
        val url = "http://10.0.2.2/anmp_uts_service/login.php"

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener<String> { response ->
                // Cek apakah respons adalah "Login berhasil"
                if (response.trim() == "Login berhasil") {
                    // Handle successful login response
                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                    // You can navigate to MainActivity
                    Log.d("Response", response) // Log response
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Menutup LoginActivity setelah berhasil login
                } else {
                    // Respons tidak sesuai dengan yang diharapkan, handle sesuai kebutuhan
                    // Contoh: menampilkan pesan kesalahan
                    Toast.makeText(this, "Respons tidak sesuai: $response", Toast.LENGTH_SHORT).show()
                    Log.e("Response", "Respons tidak sesuai: $response")
                }
            },
            Response.ErrorListener { error ->
                // Handle error
                val errorMessage = "Error occurred: " + error.message
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                // You can display an error message
                Log.e("Error", errorMessage) // Log error message
            }) {

            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["username"] = txtUsername.text.toString()
                params["password"] = txtPassword.text.toString()
                return params
            }
        }

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

}
