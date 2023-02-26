package com.example.desafiodsm_ar190019_mn190349

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

lateinit var nombreEmpleado: EditText
lateinit var codigoEmpleado: EditText
lateinit var ventasRealizadas: EditText
lateinit var mesVentas: EditText
lateinit var calcComi: Button
class Ejercicio1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        nombreEmpleado = findViewById(R.id.TxtNombre)
        codigoEmpleado = findViewById(R.id.TxtCodigo)
        ventasRealizadas = findViewById(R.id.TxtVentas)
        mesVentas = findViewById(R.id.TxtMes)
        calcComi = findViewById(R.id.BtnResultados)

        calcComi.setOnClickListener {
            var empleadoCompleto: String = nombreEmpleado.text.toString()
            var codigoEmp: Int = codigoEmpleado.text.toString().toInt()
            var ventas: Float = ventasRealizadas.text.toString().toFloat()
            var mesVent: String = mesVentas.text.toString()

            var resumen: String = "Nombre: " + empleadoCompleto +
                    "\nCódigo empleado: " + codigoEmp +
                    "\nVentas realizadas: $" + ventas +
                    "\nMes: " + mesVent +
                    "\nComisión: $" + if(ventas < 500){
                        "No hay comisión :C"
        }else if(ventas >=500 && ventas < 1000){
            ventas*0.05
            }else if(ventas >=1000 && ventas < 2000){
                ventas*0.1
            }else if(ventas >=2000 && ventas < 3000){
                ventas*0.15
            }else if(ventas >=3000 && ventas < 4000){
                ventas*0.2
            }else{
                ventas*0.3
            }

            val intent = Intent(this, MuestraDatos1::class.java)
            intent.putExtra("DatosCliente", resumen)
            startActivity(intent)

        }

    }
}