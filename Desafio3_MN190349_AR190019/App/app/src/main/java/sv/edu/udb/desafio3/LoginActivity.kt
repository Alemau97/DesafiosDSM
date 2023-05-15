package sv.edu.udb.desafio3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import sv.edu.udb.desafio3.DB.HelperDB

class LoginActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var txtLogEmail = findViewById<EditText>(R.id.txtLoginEmail)
        var txtLogPassword = findViewById<EditText>(R.id.txtLoginPassword)
        var btnlogin = findViewById<Button>(R.id.btnLoginIngresar)

        val email = txtLogEmail.text.toString().trim()
        val password = txtLogPassword.text.toString().trim()

        val db = HelperDB(this).writableDatabase
        val cursor = db.rawQuery("SELECT email FROM usuario", null)

        btnlogin.setOnClickListener {
            while(cursor.moveToNext()){
                val dataemail = cursor.getString(cursor.getColumnIndex("email"))
                if(email == dataemail){
                    Toast.makeText(this,"Usuario verificado",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Usuario no verificado",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}