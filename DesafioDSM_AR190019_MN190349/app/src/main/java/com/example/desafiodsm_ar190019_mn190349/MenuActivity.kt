package com.example.desafiodsm_ar190019_mn190349

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val vDisplay = findViewById<TextView>(R.id.txt_display)

        val sharedPreference = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)
        val usuario = sharedPreference.getString("USERNAME","").toString()
        val contrasena = sharedPreference.getString("PASSWORD","").toString()
        vDisplay.text = "El Usuario es: $usuario , la contraseña es $contrasena"

        val vLogOut = findViewById<Button>(R.id.btn_logout)

        vLogOut.setOnClickListener {

            val edition = sharedPreference.edit()

            val hnombreUsuario = ""
            val hncontrasena = ""

            edition.putString("USERNAME", hnombreUsuario)
            edition.putString("PASSWORD", hncontrasena)

            edition.apply()

            val r = Intent(this,LogeoActivity::class.java)
            startActivity(r)
        }

        val btnmovimiento1 = findViewById<Button>(R.id.ejercicio1)
        val btnmovimiento2 = findViewById<Button>(R.id.ejercicio2)

        btnmovimiento1.setOnClickListener{
            val move = Intent(this,Ejercicio1Activity::class.java)
            startActivity(move)
        }

        btnmovimiento2.setOnClickListener{
            val move = Intent(this,Ejercicio2Activity::class.java)
            startActivity(move)
        }
    }
}