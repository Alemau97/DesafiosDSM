package com.example.desafiodsm_ar190019_mn190349

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LogeoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logueo)

        val vLogin = findViewById<Button>(R.id.btn_Ingresar)
        val vUsuario = findViewById<EditText>(R.id.txt_usuario)
        val vContrasena = findViewById<EditText>(R.id.txt_contrasena)

        val sharedPreference = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)
        val getusuario = sharedPreference.getString("USERNAME","")
        val getcontrasena = sharedPreference.getString("PASSWORD", "")

        vLogin.setOnClickListener {

            val nombreUsuario = vUsuario.text.toString()
            val contrasena = vContrasena.text.toString()

            val edition = sharedPreference.edit()
            edition.putString("USERNAME", nombreUsuario)
            edition.putString("PASSWORD", contrasena)

            edition.apply()

            if(getusuario == "UsuarioSecreto" && getcontrasena == "ContrasenaSecreta"){

                val i =Intent(this,MenuActivity::class.java)
                startActivity(i)
            }
        }
    }
}