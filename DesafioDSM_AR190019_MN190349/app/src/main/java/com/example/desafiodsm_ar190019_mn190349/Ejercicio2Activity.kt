package com.example.desafiodsm_ar190019_mn190349

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

lateinit var resultado: TextView
lateinit var resultado2: TextView
lateinit var calcular: Button

class Ejercicio2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        var variableA = findViewById<EditText>(R.id.txtVariableA)
        var variableB = findViewById<EditText>(R.id.txtVariableB)
        var variableC = findViewById<EditText>(R.id.txtVariableC)
        calcular = findViewById(R.id.btnResultado)
        resultado = findViewById(R.id.lblResultado)
        resultado2 = findViewById(R.id.lblResultado2)

        calcular.setOnClickListener{


            if(variableA.text.toString()!=""&& variableB.text.toString()!=""&&variableC.text.toString()!="") {
                val exponente = 2
                val raiz = Math.pow(variableB.text.toString().toDouble(),
                    exponente.toDouble()
                ) - 4 * (variableA.text.toString().toDouble()) * (variableC.text.toString()
                    .toDouble())
                if (raiz >= 0 && variableA.text.toString().toDouble() != 0.0) {
                    resultado.setText(
                        "La suma es: " + (((-1) * variableB.text.toString().toDouble() + Math.sqrt(
                            Math.pow(
                                variableB.text.toString().toDouble(),
                                exponente.toDouble()
                            ) - 4 * (variableA.text.toString()
                                .toDouble()) * (variableC.text.toString()
                                .toDouble())
                        )) / (2 * (variableA.text.toString().toDouble())))

                    )
                    resultado2.setText(
                        "La suma es: " + (((-1) * variableB.text.toString().toDouble() - Math.sqrt(
                            Math.pow(
                                variableB.text.toString().toDouble(),
                                exponente.toDouble()
                            ) - 4 * (variableA.text.toString()
                                .toDouble()) * (variableC.text.toString()
                                .toDouble())
                        )) / (2 * (variableA.text.toString().toDouble())))
                    )
                } else {
                    resultado.setText(
                        "El resultado no puede ser calculable: MATH ERROR"
                    )
                    resultado2.setText(
                        ""
                    )
                }
            }
            else{
                resultado.setText(
                    "Debe llenar todos los campos para poder calcular el resultado"
                )
                resultado2.setText(
                    ""
                )
            }
        }

    }
}