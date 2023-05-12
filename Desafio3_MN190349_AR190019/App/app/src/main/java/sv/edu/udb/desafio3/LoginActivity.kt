package sv.edu.udb.desafio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import sv.edu.udb.desafio3.DB.HelperDB

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var txtEmail = findViewById<EditText>(R.id.txtLoginEmail)
        var txtPassword = findViewById<EditText>(R.id.txtLoginPassword)
        var btnlogin = findViewById<Button>(R.id.btnLoginIngresar)

        val email = txtEmail.text.toString().trim()
        val password = txtPassword.text.toString().trim()

        val dbHandler = HelperDB(this)
        val db = dbHandler.readableDatabase

        btnlogin.setOnClickListener {
            val cursor = db.rawQuery("SELECT * FROM usuario WHERE user=? AND password=?", arrayOf(email,password))
            if(cursor.moveToFirst()){
                Toast.makeText(this,"Bienvenid@ usuario/Admin", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
            cursor.close()
            db.close()
        }
    }
}