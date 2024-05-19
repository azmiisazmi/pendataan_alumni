package pnj.uts.ti.ahmad_ulul_azmi

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pnj.uts.ti.ahmad_ulul_azmi.Database.DatabaseManager
import java.util.Calendar

class TambahData : AppCompatActivity() {

    private lateinit var dbManager: DatabaseManager
    private lateinit var etDateOfBirth: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_data)

        dbManager = DatabaseManager(this)

        val etNim: EditText = findViewById(R.id.etNIM)
        val etName: EditText = findViewById(R.id.etName)
        val etPlaceOfBirth: EditText = findViewById(R.id.etPlaceOfBirth)
        etDateOfBirth = findViewById(R.id.etDateOfBirth)
        val etAddress: EditText = findViewById(R.id.etAddress)
        val etReligion: EditText = findViewById(R.id.etReligion)
        val etPhone: EditText = findViewById(R.id.etPhone)
        val etYearOfEntry: EditText = findViewById(R.id.etYearOfEntry)
        val etYearOfGraduation: EditText = findViewById(R.id.etYearOfGraduation)
        val etJob: EditText = findViewById(R.id.etJob)
        val etPosition: EditText = findViewById(R.id.etPosition)
        val btnSave: Button = findViewById(R.id.btnSave)

        etDateOfBirth.setOnClickListener {
            showDatePickerDialog()
        }

        btnSave.setOnClickListener {
            val nim = etNim.text.toString()
            val name = etName.text.toString()
            val placeOfBirth = etPlaceOfBirth.text.toString()
            val dateOfBirth = etDateOfBirth.text.toString()
            val address = etAddress.text.toString()
            val religion = etReligion.text.toString()
            val phone = etPhone.text.toString()
            val yearOfEntry = etYearOfEntry.text.toString().toIntOrNull() ?: 0
            val yearOfGraduation = etYearOfGraduation.text.toString().toIntOrNull() ?: 0
            val job = etJob.text.toString()
            val position = etPosition.text.toString()

            if (nim.isNotEmpty() && name.isNotEmpty() && dateOfBirth.isNotEmpty()) {
                dbManager.insertRecord(nim, name, placeOfBirth, dateOfBirth, address, religion, phone, yearOfEntry, yearOfGraduation, job, position)
                Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
                finish()  // Close activity after saving
            } else {
                Toast.makeText(this, "Please fill out all required fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            etDateOfBirth.setText(selectedDate)
        }, year, month, day)

        datePickerDialog.show()
    }

    override fun onDestroy() {
        dbManager.close()
        super.onDestroy()
    }
}