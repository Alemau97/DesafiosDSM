package sv.edu.udb.desafio3.Models

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import sv.edu.udb.desafio3.DB.HelperDB

class Marcas(context: Context?){
    private var helper: HelperDB? = null
    private var db: SQLiteDatabase? = null

    init {
        helper = HelperDB(context)
        db = helper!!.getWritableDatabase()
    }
    companion object{
        //Estableciendo tabla
        val TABLE_NAME_MARCAS = "marcas"
        //estableciendo campos
        val COL_ID = "idmarcas"
        val COL_NOMBRE = "nombre"

        //Crear tabla
        val CREATE_TABLE_MARCAS = ("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_MARCAS + "(" + COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_NOMBRE + "VARCHAR(50);")
    }

    //ContentValues
    fun generarContentValues(
        nombre: String?
    ):ContentValues? {
        val valores = ContentValues()
        valores.put(COL_NOMBRE, nombre)
        return valores
    }

    //Mostrando datos
    fun showAllCategoria(): Cursor? {
        val columns = arrayOf(COL_ID, COL_NOMBRE)
        return db!!.query(
            TABLE_NAME_MARCAS, columns,
            null, null, null, null, "$COL_NOMBRE ASC"
        )
    }

    // Debido a que el Spinner solamente guarda el nombre, esta funcion nos ayudara a recuperar el ID de la categoria
    fun searchID(nombre: String): Int? {
        val columns = arrayOf(COL_ID, COL_NOMBRE)
        var cursor: Cursor? = db!!.query(
            TABLE_NAME_MARCAS, columns,
            "$COL_NOMBRE=?", arrayOf(nombre.toString()), null, null, null
        )
        cursor!!.moveToFirst()
        return cursor!!.getInt(0)
    }

    fun searchNombre(id: Int): String? {
        val columns = arrayOf(COL_ID, COL_NOMBRE)
        var cursor: Cursor? = db!!.query(
            TABLE_NAME_MARCAS, columns,
            "$COL_ID=?", arrayOf(id.toString()), null, null, null
        )
        cursor!!.moveToFirst()
        return cursor!!.getString(1)
    }


}