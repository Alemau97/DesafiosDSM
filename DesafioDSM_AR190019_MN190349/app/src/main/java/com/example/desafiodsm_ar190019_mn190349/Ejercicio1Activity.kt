package com.example.desafiodsm_ar190019_mn190349

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
lateinit var resultComis: TextView
class Ejercicio1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        nombreEmpleado = findViewById(R.id.TxtNombre)
        codigoEmpleado = findViewById(R.id.TxtCodigo)
        ventasRealizadas = findViewById(R.id.TxtVentas)
        mesVentas = findViewById(R.id.TxtMes)
        calcComi = findViewById(R.id.BtnResultados)
        resultComis = findViewById(R.id.LlbResultadoComis)

        calcComi.setOnClickListener {
            var empleadoCompleto: String = nombreEmpleado.text.toString()
            var codigoEmp: Int = codigoEmpleado.text.toString().toInt()
            var ventas: Float = ventasRealizadas.text.toString().toFloat()
            var mesVent: String = mesVentas.text.toString()

            if(ventas < 500){
                resultComis.setText(
                    "Nombre: " + empleadoCompleto +
                            "Código" + codigoEmp +
                            "Ventas: $" + ventas +
                            "Mes actual: " + mesVent +
                    "No es acreedor de una comisión :(")
            }else if(ventas >=500 && ventas < 1000){
                resultComis.setText(
                    "Nombre: " + empleadoCompleto +
                            "Código" + codigoEmp +
                            "Ventas: $" + ventas +
                            "Mes actual: " + mesVent +
                            "Comisión: $" + ventas*0.05)
            }else if(ventas >=1000 && ventas < 2000){
                resultComis.setText(
                    "Nombre: " + empleadoCompleto +
                            "Código" + codigoEmp +
                            "Ventas: $" + ventas +
                            "Mes actual: " + mesVent +
                            "Comisión: $" +ventas*0.1)
            }else if(ventas >=2000 && ventas < 3000){
                resultComis.setText(
                    "Nombre: " + empleadoCompleto +
                            "Código" + codigoEmp +
                            "Ventas: $" + ventas +
                            "Mes actual: " + mesVent +
                            "Comisión: $" +ventas*0.15)
            }else if(ventas >=3000 && ventas < 4000){
                resultComis.setText(
                    "Nombre: " + empleadoCompleto +
                            "Código" + codigoEmp +
                            "Ventas: $" + ventas +
                            "Mes actual: " + mesVent +
                            "Comisión: $" +ventas*0.2)
            }else{
                resultComis.setText(
                    "Nombre: " + empleadoCompleto +
                            "Código" + codigoEmp +
                            "Ventas: $" + ventas +
                            "Mes actual: " + mesVent +
                            "Comisión: $" +ventas*0.3)
            }
        }

    }
}