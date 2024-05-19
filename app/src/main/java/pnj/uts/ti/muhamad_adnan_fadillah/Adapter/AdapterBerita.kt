package pnj.uts.ti.ahmad_ulul_azmi.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import pnj.uts.ti.ahmad_ulul_azmi.Data.BeritaData
import pnj.uts.ti.ahmad_ulul_azmi.R

class AdapterBerita(
    private val context: Activity,
    private val arrayList: ArrayList<BeritaData>
    ) : ArrayAdapter<BeritaData>(context, R.layout.itemberita, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.itemberita, null)

        val imageView : ImageView = view.findViewById(R.id.imageView)
        val title : TextView = view.findViewById(R.id.txtTitle)
        val desc : TextView = view.findViewById(R.id.txtDesc)

        imageView.setImageResource(arrayList[position].imageId)
        title.text = arrayList[position].judul
        desc.text = arrayList[position].deskripsi

        return view
    }
}