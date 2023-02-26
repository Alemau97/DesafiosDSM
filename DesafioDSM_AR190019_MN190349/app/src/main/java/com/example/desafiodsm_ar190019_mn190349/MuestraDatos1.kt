package com.example.desafiodsm_ar190019_mn190349

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.TextView

lateinit var muestraResultados: TextView

class MuestraDatos1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muestra_datos1)

        muestraResultados = findViewById(R.id.LlbMuestra)

        val bundle = intent.extras
        val dato = bundle?.getString("DatosCliente")

        muestraResultados.setText(dato)
    }
}