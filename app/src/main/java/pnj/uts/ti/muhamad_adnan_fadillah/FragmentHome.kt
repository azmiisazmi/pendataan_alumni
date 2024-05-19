package pnj.uts.ti.ahmad_ulul_azmi

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import pnj.uts.ti.ahmad_ulul_azmi.Fragment.FragmentOne
import pnj.uts.ti.ahmad_ulul_azmi.Fragment.FragmentThree
import pnj.uts.ti.ahmad_ulul_azmi.Fragment.FragmentTwo
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment_home)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        // Set the initial fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerLayout, FragmentOne())
                .commit()
        }

        // Set up the bottom navigation listener
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> selectedFragment = FragmentOne()
                R.id.nav_berita -> selectedFragment = FragmentTwo()
                R.id.nav_profile -> selectedFragment = FragmentThree()
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.containerLayout, selectedFragment)
                    .commit()
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.top_navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menu_add_data -> {
                // Handle Add Data option
                val intent = Intent(this, TambahData::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_alumni_data -> {
                // Handle Alumni Data option
                val intent = Intent(this, DataAlumni::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_logout -> {
                // Handle Logout option
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun enableEdgeToEdge() {
        // Implement this method if necessary to enable edge-to-edge display
    }
}