package pnj.uts.ti.ahmad_ulul_azmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pnj.uts.ti.ahmad_ulul_azmi.databinding.ActivityDetailBeritaBinding

class DetailBerita : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBeritaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBeritaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val imageId = intent.getIntExtra("imageId", R.drawable.img_productimage_1)

        binding.txtjudul.text = title
        binding.txtDescription.text = desc
        binding.imgView.setImageResource(imageId)
    }
}