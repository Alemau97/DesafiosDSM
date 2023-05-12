package sv.edu.udb.desafio3.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HelperDB(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        private const val DATABASE_NAME = "CarsMotors.db"
        private const val DATABASE_VERSION = 1
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_Usuarios =
            "CREATE TABLE IF NOT EXISTS usuario (" +
                    "idusuario INTEGER PRIMARY KEY, " +
                    "nombres varchar(45)," +
                    "apellidos varchar(45)," +
                    "email varchar(45)," +
                    "user varchar(45)," +
                    "password varchar(45)," +
                    "tipo varchar(45))"
        db?.execSQL(CREATE_Usuarios)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val DROP_Usuarios = "DROP TABLE IF EXISTS usuario"
        db?.execSQL(DROP_Usuarios)
        onCreate(db)
    }


}