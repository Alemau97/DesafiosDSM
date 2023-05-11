package sv.edu.udb.desafio3.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HelperDB(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        private const val DATABASE_NAME = "CarsMotors.db"
        private const val DATABASE_VERSION = 1
        private const val ID = "idmarcas"
        private const val nombre = "nombre"
        private const val TABLE_NAME_MARCA = "marca"
        private const val COL_ID = "idmarcas"
        private const val COL_NOMBRE = "nombre"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createMarca = ("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_MARCA + "("
                + COL_ID + "integer primary key autoincrement, "
                +COL_NOMBRE + "varchar(45);")
        db?.execSQL(createMarca)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_MARCA")
    }
}