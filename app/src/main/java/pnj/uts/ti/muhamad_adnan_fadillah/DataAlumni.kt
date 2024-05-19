package pnj.uts.ti.ahmad_ulul_azmi

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.AlumniAdapter
import pnj.uts.ti.ahmad_ulul_azmi.Database.DatabaseManager
import pnj.uts.ti.ahmad_ulul_azmi.R

class DataAlumni : AppCompatActivity() {

    private lateinit var dbManager: DatabaseManager
    private lateinit var cursor: Cursor
    private lateinit var adapter: AlumniAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_alumni)

        dbManager = DatabaseManager(this)
        cursor = dbManager.readAllRecords()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AlumniAdapter(cursor) { id ->
            val intent = Intent(this, DetailDataAlumni::class.java)
            intent.putExtra("RECORD_ID", id)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        cursor.close()
        dbManager.close()
        super.onDestroy()
    }
}
