package pnj.uts.ti.ahmad_ulul_azmi.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "AlumniDatabase.db"
        const val TABLE_NAME = "alumni"
        const val COLUMN_ID = "id"
        const val COLUMN_NIM = "nim"
        const val COLUMN_NAME = "name"
        const val COLUMN_PLACE_OF_BIRTH = "place_of_birth"
        const val COLUMN_DATE_OF_BIRTH = "date_of_birth"
        const val COLUMN_ADDRESS = "address"
        const val COLUMN_RELIGION = "religion"
        const val COLUMN_PHONE = "phone"
        const val COLUMN_YEAR_OF_ENTRY = "year_of_entry"
        const val COLUMN_YEAR_OF_GRADUATION = "year_of_graduation"
        const val COLUMN_JOB = "job"
        const val COLUMN_POSITION = "position"

        const val CREATE_TABLE = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NIM TEXT,
                $COLUMN_NAME TEXT,
                $COLUMN_PLACE_OF_BIRTH TEXT,
                $COLUMN_DATE_OF_BIRTH TEXT,
                $COLUMN_ADDRESS TEXT,
                $COLUMN_RELIGION TEXT,
                $COLUMN_PHONE TEXT,
                $COLUMN_YEAR_OF_ENTRY INTEGER,
                $COLUMN_YEAR_OF_GRADUATION INTEGER,
                $COLUMN_JOB TEXT,
                $COLUMN_POSITION TEXT
            )
        """
    }
}
