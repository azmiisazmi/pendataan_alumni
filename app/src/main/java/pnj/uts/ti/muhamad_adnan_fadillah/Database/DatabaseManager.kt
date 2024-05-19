package pnj.uts.ti.ahmad_ulul_azmi.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context) : SQLiteOpenHelper(context,
    DatabaseHelper.DATABASE_NAME, null,
    DatabaseHelper.DATABASE_VERSION
) {

    override fun onCreate(db: SQLiteDatabase) {
//        db.execSQL(DatabaseHelper.CREATE_TABLE)
        db.execSQL(DatabaseHelper.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${DatabaseHelper.TABLE_NAME}")
        onCreate(db)
    }

    fun readAllRecords(): Cursor {
        val db = this.readableDatabase
        return db.query(
            DatabaseHelper.TABLE_NAME,
            null, null, null, null, null,
            "${DatabaseHelper.COLUMN_NAME} ASC"
        )
    }

    fun readRecord(id: Long): Cursor {
        val db = this.readableDatabase
        return db.query(
            DatabaseHelper.TABLE_NAME,
            null,
            "${DatabaseHelper.COLUMN_ID} = ?",
            arrayOf(id.toString()),
            null, null, null
        )
    }

    fun insertRecord(nim: String, name: String, placeOfBirth: String, dateOfBirth: String, address: String, religion: String, phone: String, yearOfEntry: Int, yearOfGraduation: Int, job: String, position: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NIM, nim)
            put(DatabaseHelper.COLUMN_NAME, name)
            put(DatabaseHelper.COLUMN_PLACE_OF_BIRTH, placeOfBirth)
            put(DatabaseHelper.COLUMN_DATE_OF_BIRTH, dateOfBirth)
            put(DatabaseHelper.COLUMN_ADDRESS, address)
            put(DatabaseHelper.COLUMN_RELIGION, religion)
            put(DatabaseHelper.COLUMN_PHONE, phone)
            put(DatabaseHelper.COLUMN_YEAR_OF_ENTRY, yearOfEntry)
            put(DatabaseHelper.COLUMN_YEAR_OF_GRADUATION, yearOfGraduation)
            put(DatabaseHelper.COLUMN_JOB, job)
            put(DatabaseHelper.COLUMN_POSITION, position)
        }
        return db.insert(DatabaseHelper.TABLE_NAME, null, values)
    }

    fun updateRecord(id: Long, nim: String, name: String, placeOfBirth: String, dateOfBirth: String, address: String, religion: String, phone: String, yearOfEntry: Int, yearOfGraduation: Int, job: String, position: String): Int {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NIM, nim)
            put(DatabaseHelper.COLUMN_NAME, name)
            put(DatabaseHelper.COLUMN_PLACE_OF_BIRTH, placeOfBirth)
            put(DatabaseHelper.COLUMN_DATE_OF_BIRTH, dateOfBirth)
            put(DatabaseHelper.COLUMN_ADDRESS, address)
            put(DatabaseHelper.COLUMN_RELIGION, religion)
            put(DatabaseHelper.COLUMN_PHONE, phone)
            put(DatabaseHelper.COLUMN_YEAR_OF_ENTRY, yearOfEntry)
            put(DatabaseHelper.COLUMN_YEAR_OF_GRADUATION, yearOfGraduation)
            put(DatabaseHelper.COLUMN_JOB, job)
            put(DatabaseHelper.COLUMN_POSITION, position)
        }
        return db.update(DatabaseHelper.TABLE_NAME, values, "${DatabaseHelper.COLUMN_ID} = ?", arrayOf(id.toString()))
    }

    fun deleteRecord(id: Long): Int {
        val db = this.writableDatabase
        return db.delete(DatabaseHelper.TABLE_NAME, "${DatabaseHelper.COLUMN_ID} = ?", arrayOf(id.toString()))
    }
}
