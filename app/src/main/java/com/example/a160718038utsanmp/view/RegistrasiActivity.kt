package com.example.a160718038utsanmp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160718038utsanmp.R

class RegistrasiActivity : AppCompatActivity() {

    private lateinit var txtUsername: EditText
    private lateinit var txtPassword: EditText
    private lateinit var txtEmail: EditText
    private lateinit var txtNamaDepan: EditText
    private lateinit var txtNamaBelakang: EditText
    private lateinit var btnRegistrasi: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)
        txtEmail = findViewById(R.id.txtEmail)
        txtNamaDepan = findViewById(R.id.txtNamaDepan)
        txtNamaBelakang = findViewById(R.id.txtNamaBelakang)
        btnRegistrasi = findViewById(R.id.btnRegis)

        btnRegistrasi.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val queue = Volley.newRequestQueue(this)
        val url = "http://10.0.2.2/anmp_uts_service/register.php"

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener<String> { response ->
                // Handle successful registration response
                Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                // You can display a toast or navigate to another activity
                Log.d("Response", response) // Log response
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Menutup LoginActivity setelah berhasil login
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
                params["email"] = txtEmail.text.toString()
                params["nama_depan"] = txtNamaDepan.text.toString()
                params["nama_belakang"] = txtNamaBelakang.text.toString()
                return params
            }
        }

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}
