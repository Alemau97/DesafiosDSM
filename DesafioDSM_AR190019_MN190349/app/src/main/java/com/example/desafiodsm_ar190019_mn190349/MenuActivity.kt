package com.example.desafiodsm_ar190019_mn190349

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}