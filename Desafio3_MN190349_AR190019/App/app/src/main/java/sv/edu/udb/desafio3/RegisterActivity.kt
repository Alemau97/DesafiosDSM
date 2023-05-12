package sv.edu.udb.desafio3

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import sv.edu.udb.desafio3.DB.HelperDB

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var txtNombres = findViewById<EditText>(R.id.txtNombre)
        var txtApellidos = findViewById<EditText>(R.id.txtApellido)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        var txtUsuario = findViewById<EditText>(R.id.txtUserName)
        var txtPassword = findViewById<EditText>(R.id.txtPassword)
        var txtRePassword = findViewById<EditText>(R.id.txtRePassword)
        val btnRegistrar= findViewById<AppCompatButton>(R.id.btnRegistrar)
        val lblLogeo: TextView = findViewById(R.id.lblLogin)


        val dbHandler = HelperDB(this)

        btnRegistrar.setOnClickListener{
            val Nombres = txtNombres.text.toString()
            val Apellidos = txtApellidos.text.toString()
            val Email = txtEmail.text.toString()
            val Usuario = txtUsuario.text.toString()
            val Password = txtPassword.text.toString()
            val RePassword = txtRePassword.text.toString()

            if(Nombres.isEmpty() || Apellidos.isEmpty() || Email.isEmpty() || Usuario.isEmpty() || Password.isEmpty() || RePassword.isEmpty()){
                Toast.makeText(this,"Llena todos los campos",Toast.LENGTH_SHORT).show()
            }
            else{
                if(Password == RePassword){
                    val values = ContentValues()
                    values.put("nombres",Nombres)
                    values.put("apellidos", Apellidos)
                    values.put("email",Email)
                    values.put("user",Usuario)
                    values.put("password",Password)
                    values.put("tipo","Admin")
                    dbHandler.writableDatabase.insert("usuario",null,values)
                    Toast.makeText(this,"Datos ingresados exitosamente",Toast.LENGTH_SHORT).show()

                }
                else{
                    Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show()
                }

            }
        }

        lblLogeo.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}