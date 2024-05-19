package pnj.uts.ti.ahmad_ulul_azmi

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pnj.uts.ti.ahmad_ulul_azmi.Database.DatabaseHelper
import pnj.uts.ti.ahmad_ulul_azmi.Database.DatabaseManager
import java.util.Calendar

class DetailDataAlumni : AppCompatActivity() {

    private lateinit var dbManager: DatabaseManager
    private lateinit var etNim: EditText
    private lateinit var etName: EditText
    private lateinit var etPlaceOfBirth: EditText
    private lateinit var etDateOfBirth: EditText
    private lateinit var etAddress: EditText
    private lateinit var etReligion: EditText
    private lateinit var etPhone: EditText
    private lateinit var etYearOfEntry: EditText
    private lateinit var etYearOfGraduation: EditText
    private lateinit var etJob: EditText
    private lateinit var etPosition: EditText

    private var recordId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_data_alumni)

        dbManager = DatabaseManager(this)

        etNim = findViewById(R.id.etNim)
        etName = findViewById(R.id.etName)
        etPlaceOfBirth = findViewById(R.id.etPlaceOfBirth)
        etDateOfBirth = findViewById(R.id.etDateOfBirth)
        etAddress = findViewById(R.id.etAddress)
        etReligion = findViewById(R.id.etReligion)
        etPhone = findViewById(R.id.etPhone)
        etYearOfEntry = findViewById(R.id.etYearOfEntry)
        etYearOfGraduation = findViewById(R.id.etYearOfGraduation)
        etJob = findViewById(R.id.etJob)
        etPosition = findViewById(R.id.etPosition)

        etDateOfBirth.setOnClickListener {
            showDatePickerDialog()
        }

        val btnUpdate: Button = findViewById(R.id.btnUpdate)
        val btnDelete: Button = findViewById(R.id.btnDelete)

        recordId = intent.getLongExtra("RECORD_ID", -1)
        if (recordId != -1L) {
            loadRecordData(recordId)
        }

        btnUpdate.setOnClickListener {
            updateRecord()
        }

        btnDelete.setOnClickListener {
            deleteRecord()
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

    private fun loadRecordData(id: Long) {
        val cursor = dbManager.readRecord(id)
        if (cursor.moveToFirst()) {
            etNim.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NIM)))
            etName.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME)))
            etPlaceOfBirth.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PLACE_OF_BIRTH)))
            etDateOfBirth.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DATE_OF_BIRTH)))
            etAddress.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ADDRESS)))
            etReligion.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_RELIGION)))
            etPhone.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PHONE)))
            etYearOfEntry.setText(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_YEAR_OF_ENTRY)).toString())
            etYearOfGraduation.setText(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_YEAR_OF_GRADUATION)).toString())
            etJob.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOB)))
            etPosition.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_POSITION)))
        }
        cursor.close()
    }

    private fun updateRecord() {
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
            dbManager.updateRecord(recordId, nim, name, placeOfBirth, dateOfBirth, address, religion, phone, yearOfEntry, yearOfGraduation, job, position)
            Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show()
            finish()  // Close activity after updating
        } else {
            Toast.makeText(this, "Please fill out all required fields", Toast.LENGTH_SHORT).show()
        }
        finish()  // Close activity after deleting
    }

    private fun deleteRecord() {
        dbManager.deleteRecord(recordId)
        Toast.makeText(this, "Data deleted successfully", Toast.LENGTH_SHORT).show()
        finish()  // Close activity after deleting
    }

    override fun onDestroy() {
        dbManager.close()
        super.onDestroy()
    }
}
