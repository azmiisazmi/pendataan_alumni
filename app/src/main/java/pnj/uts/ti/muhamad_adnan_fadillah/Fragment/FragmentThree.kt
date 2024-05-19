package pnj.uts.ti.ahmad_ulul_azmi.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import pnj.uts.ti.ahmad_ulul_azmi.MainActivity
import pnj.uts.ti.ahmad_ulul_azmi.R

class FragmentThree : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_fragment_three, container, false)

        // Retrieve the stored values from SharedPreferences
        val sharedPreferences = activity?.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val email = sharedPreferences?.getString("email", "")
        val name = sharedPreferences?.getString("name", "")
        val nim = sharedPreferences?.getString("nim", "")
        val kelas = sharedPreferences?.getString("kelas", "")

        // Display the values
        view.findViewById<TextView>(R.id.textEmail).text = "Email: $email"
        view.findViewById<TextView>(R.id.textName).text = "Nama: $name"
        view.findViewById<TextView>(R.id.textNumber).text = "NIM: $nim"
        view.findViewById<TextView>(R.id.textOccupation).text = "Kelas: $kelas"

        // Handle logout button click
        val logoutButton = view.findViewById<Button>(R.id.buttonLogout)
        logoutButton.setOnClickListener {
            // Clear the shared preferences
            sharedPreferences?.edit()?.clear()?.apply()

            // Navigate back to MainActivity
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()  // Optional: close the current activity
        }

        return view
    }
}
