package pnj.uts.ti.ahmad_ulul_azmi.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pnj.uts.ti.ahmad_ulul_azmi.Adapter.AdapterBerita
import pnj.uts.ti.ahmad_ulul_azmi.Data.BeritaData
import pnj.uts.ti.ahmad_ulul_azmi.DetailBerita
import pnj.uts.ti.ahmad_ulul_azmi.R
import pnj.uts.ti.ahmad_ulul_azmi.databinding.ActivityFragmentTwoBinding

class FragmentTwo : Fragment() {

    private lateinit var binding: ActivityFragmentTwoBinding
    private lateinit var beritaArraylist : ArrayList<BeritaData>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for the fragment
        binding = ActivityFragmentTwoBinding.inflate(inflater, container, false)

        // Initialize the data
        val imageId = intArrayOf(
            R.drawable.berita1,
            R.drawable.berita2,
            R.drawable.berita3,
            R.drawable.berita4,
            R.drawable.berita5,
            R.drawable.berita6,
            R.drawable.berita7,
            R.drawable.berita8,
            R.drawable.berita9,
            R.drawable.berita10
        )

        val title = arrayOf(
            "Kemeriahan Lebaran Depok 2024, Pengisi Acara: Senang Bisa Tampil di Acara Sebesar Ini",
            "Arsitek Provinsi Gorontalo Ditantang Ciptakan Bangunan Ciri Khas Daerah",
            "Berita terpopuler akhir pekan, casis Bintara korban begal diterima masuk Polri hingga DKI tindak tegas penerima setoran dari juru parkir liar",
            "Penjagub Rudy Salahuddin Tiba di Gorontalo Disambut Adat Mopotilolo",
            "Peluncuran Buku Kerajaan dan Kesultanan Nusantara, Bobby Nasution: Bangga dengan Sejarah dan Keberagaman Budaya",
            "Selesai Digelar di Depok, Tahun Depan Pekalongan Jadi Tuan Rumah Rakerkomwil III APEKSI",
            "Akhiri Jabatan Penjabat Gubernur, Ismail Pakaya Jalani Adat Modepito",
            "Ladies Program Rakerkomwil III APEKSI, Istri Kepala Daerah Buat Kalung Batik dan Oshibana",
            "Kreasi Cantik Kerajinan Bunga Tekan ala Oshibana Buatan Bunda Elly",
            "Tradisi Potong Kebo Andil di Lebaran Depok 2024"
        )

        val desc = arrayOf(
            "Gelaran Lebaran Depok 2024 di Alun-Alun Kota Depok sukses menghadirkan hiburan yang kaya akan budaya dan tradisi, menciptakan momen kebersamaan yang tak terlupakan bagi seluruh masyarakat Depok. Hari kedua dipenuhi oleh penonton yang antusias menyaksikan berbagai penampilan memukau dari para penampil, yang berasal dari berbagai sanggar dan komunitas seni. Mulai dari penampilan musik dan tari dari Sanggar Trisna Manggala yang menampilkan tari \"Siri Kuning\", hingga penampilan musik tradisional Gambang Kromong oleh Kumpulan Orang Orang Depok (KOOD) Kecamatan Cilodong. Setiap penampilan membawa keunikan dan kekhasan tersendiri, memperkaya keberagaman budaya yang ditampilkan pada acara ini. Panggung Lebaran Depok juga dimeriahkan oleh penampilan Better Band dari SMPN 3, Band Wan, dan Band Soer Plus yang sukses menghibur penonton dengan lagu-lagu hits mereka. Acara akan ditutup dengan penampilan spektakuler Rampak Bedug Takbir dari Gambang Kromong Bang Cablak, membawa suasana Lebaran semakin meriah dengan alunan bedug yang khas.",
            "Plt. Asisten Bidang Administrasi Umum Setda Provinsi Gorontalo, Yosef P. Koton, menantang para arsitek di Provinsi tersebut untuk menciptakan bangunan yang mencerminkan ciri khas daerah, didasarkan pada adat budaya dan kepribadian orang Gorontalo. Tantangan ini diungkapkan dalam acara Peluncuran Lisensis Arsitek serta Rakerprov IAI Provinsi Gorontalo dan Diskusi Lintas Asosiasi Profesional (DILAN) seri ke-3, di Grand ballroom UTC Damhil Hotel. Yosef menekankan pentingnya lisensi arsitek sebagai sarana kendali bagi pemerintah provinsi dalam membina dan mengendalikan jasa konstruksi, serta dalam memastikan setiap kegiatan pembangunan dipertanggungjawabkan oleh arsitek yang berlisensi. Hadir dalam acara ini juga sejumlah tokoh terkait, seperti Ketua Ikatan Arsitek Indonesia Provinsi Gorontalo, Kepala Kejaksaan Tinggi Provinsi Gorontalo, dan Kepala Dinas PUPR-PKP Provinsi Gorontalo, serta perwakilan dari kabupaten/kota di Provinsi Gorontalo.",
            "Berita unggulan akhir pekan mencakup beberapa peristiwa menarik, antara lain kasus casis Bintara Polri yang menjadi korban begal namun diterima masuk Polri melalui jalur penerimaan untuk disabilitas, serta eskalasi konflik di Gaza yang telah menewaskan setidaknya 35.272 warga Palestina dan melukai lebih dari 79.205 lainnya dalam serangan Israel. Selain itu, Polda Metro Jaya dan Polda Jawa Barat bekerja sama untuk memburu pelaku utama kasus pembunuhan Vina Dewi Arsita yang masih buron, serta Kementerian Pemberdayaan Perempuan dan Perlindungan Anak menegaskan pentingnya study tour sebagai bagian dari hak anak untuk mendapatkan pendidikan di luar kelas. Terakhir, Pemerintah Provinsi DKI Jakarta mengambil tindakan tegas terhadap penerima setoran dari juru parkir liar, menegaskan bahwa akan memberikan peringatan hingga tindakan tegas terhadap pelanggar tersebut.",
            "Penjabat Gubernur Gorontalo, Rudy Salahuddin, segera bergerak menuju Gorontalo setelah dilantik. Kedatangannya, bersama istri, Djoewiati Kentjana Soebrata, di Bandara Djalaludin Gorontalo, disambut dengan prosesi adat Mopotilolo, yang merupakan rangkaian upacara untuk menyambut pejabat tinggi negara yang baru pertama kali datang ke Gorontalo. Acara ini dipimpin oleh para pemangku adat U Duluwo Limo Lo Pohalaa, dengan tabuhan genderang adat dan tarian Longgo sebagai bagian dari penyambutan. Rudy menerima persembahan adat dan petuah adat, serta doa untuk keselamatan dan kesehatannya selama bertugas di Gorontalo. Sejumlah agenda menanti Rudy di Gorontalo, termasuk perimaan adat Moloopu dan serah terima jabatan dari Penjabat Gubernur sebelumnya, Ismail Pakaya.",
            "Wali Kota Medan Bobby Nasution menekankan pentingnya kebanggaan terhadap sejarah dan kekayaan adat serta nilai-nilai budaya dalam acara Peluncuran Buku \"Kerajaan dan Kesultanan Nusantara\" Volume I. Bobby Nasution mengingatkan bahwa peradaban saat ini berasal dari cikal bakal Kesultanan dan Kerajaan yang ada. Buku tersebut, ditulis oleh Mr. Randall Rutledge, membahas sejarah Kesultanan dan Kerajaan di Pulau Sumatera, khususnya Provinsi Sumatera Utara dan Kota Medan. Bobby Nasution berharap Kesultanan dan Kerajaan di Indonesia, terutama di Sumatera Utara dan Kota Medan, dapat terus berperan dalam pembangunan daerah. Dia berharap keberadaan mereka tidak hanya menjadi cerita, tetapi juga menjadi landasan untuk mendukung pembangunan, kepemimpinan, dan perkembangan daerah tersebut. Dia berharap buku ini menjadi motivasi bagi semua orang untuk bangga dengan keragaman budaya Indonesia.",
            "Rapat Kerja Komisariat Wilayah (Rakerkomwil) III Asosiasi Pemerintah Kota seluruh Indonesia (APEKSI) di Kota Depok telah selesai dilaksanakan dengan ditutupnya puluhan poin rekomendasi yang akan disampaikan pada Rapat Kerja Nasional (Rakernas) XVII di Balikpapan. Dipimpin oleh Ketua Komisariat Wilayah (Konwil) III APEKSI, Wali Kota Cilegon, Helldy Agustian, acara tersebut dihadiri oleh 25 kepala daerah dari Jawa Barat (Jabar), Jawa Tengah (Jateng), DKI Jakarta, dan Banten. Helldy menyatakan bahwa Rakerkomwil III tahun 2024 telah selesai, dan untuk tahun 2025 akan dilaksanakan di Kota Pekalongan. APEKSI, sebagai organisasi yang beranggotakan 98 pemerintah kota di seluruh Indonesia, terbagi ke dalam enam Komwil berdasarkan wilayah. Setiap tahunnya, sebelum pelaksanaan Rakernas, keenam Komwil melakukan Rakerkomwil untuk menentukan rekomendasi program yang akan disampaikan pada Rakernas.",
            "Pemerintah Provinsi Gorontalo menggelar upacara adat Modepito untuk mengakhiri masa jabatan Ismail Pakaya sebagai Penjabat Gubernur Gorontalo. Modepito adalah prosesi adat yang mengantarkan pejabat yang berakhir masa tugasnya dari rumah jabatan ke kediaman pribadi, sebagai bentuk penghargaan atas pengabdian kepada daerah. Ismail Pakaya dan istri dijemput oleh pemangku adat untuk menuju tempat duduk adat, lalu meninggalkan rumah jabatan diantarkan oleh Bupati/Wali Kota, Forkopimda provinsi, dan pimpinan OPD. Prosesi dilanjutkan di kediaman pribadi Ismail Pakaya dengan pembacaan doa sebagai penutup. Modepito hampir sama dengan adat Mopotolungo, dengan perbedaan bahwa Mopotolungo untuk pejabat yang memasuki masa pensiun, sedangkan Modepito untuk pejabat yang masih menjabat namun berbeda. Ismail Pakaya masih menjabat sebagai Staf Ahli Bidang Sosial, Politik, dan Kebijakan Publik, Kemenaker RI. Selain Modepito, Ismail dan istri juga menghadiri upacara pelepasan yang dilakukan oleh IKAPTK Provinsi Gorontalo, di mana pasukan upacara membentuk formasi Bintang Astha Brata, simbol penghargaan tertinggi di bidang Kepamongprajaan. Ismail Pakaya menyelesaikan tugasnya pada 12 Mei 2024 dan digantikan oleh Rudy Salahuddin sebagai Penjabat Gubernur Gorontalo yang baru pada 17 Mei 2024.",
            "Ladies Program telah menjadi agenda tetap dalam Rapat Kerja Komisariat Wilayah (Rakerkomwil) III Asosiasi Pemerintah Kota seluruh Indonesia (APEKSI) setiap tahunnya, di mana para istri wali kota yang juga Ketua Tim Penggerak Pemberdayaan Kesejahteraan Keluarga (TP-PKK) diwajibkan untuk mengikuti program tersebut. Pada pelaksanaan Rakerkomwil III APEKSI tahun 2024 di Kota Depok, para istri wali kota mengikuti rangkaian kegiatan Ladies Program yang dibuka oleh istri Wali Kota Depok, Elly Farida. Mereka diajak untuk melihat festival budaya Lebaran Depok di Alun-alun Kota Depok dan mengikuti Workshop Kalung Batik dan Oshibana. Meskipun jumlah peserta terbatas, hal itu tidak mengurangi keceriaan acara yang diselenggarakan oleh Dinas Koperasi dan Usaha Mikro (DKUM) dan Dinas Perdagangan dan Perindustrian (Disdagin). Para peserta merasa terhibur dan menikmati waktu mereka dalam kegiatan ini, yang juga dianggap sebagai waktu untuk menyegarkan pikiran dari rutinitas sehari-hari. Bunda Elly berharap kegiatan ini dapat memberikan kesan yang baik dan mengingatkan bahwa istri kepala daerah juga memiliki peran penting dalam pembangunan di wilayah masing-masing.",
            "Pada Ladies Program Rapat Kerja Komisariat Wilayah (Rakerkomwil) III APEKSI 2024 di Kota Depok, beberapa workshop membuat kerajinan tangan diselenggarakan, termasuk pembuatan Kalung Batik dan Oshibana. Workshop tersebut diikuti oleh istri kepala daerah peserta Rakerkomwil III APEKSI, seperti Ketua TP-PKK Kota Depok, Elly Farida, yang membuat karya Oshibana yang menarik. Dengan latar kertas putih, Bunda Elly menyusun bunga dan daun kering menjadi karya yang abstrak namun harmonis, menggambarkan kesatuan, cita-cita, dan kebersamaan yang terbentuk melalui cinta. Oshibana adalah seni merangkai bunga atau dedaunan yang dikeringkan dengan cara dipress atau ditekan, yang dapat diaplikasikan dalam berbagai kreasi unik dan menarik.",
            "Pada acara Lebaran Depok 2024 di Alun-alun Kota Depok pada hari pertama, tradisi memotong hewan kerbau dari hasil patungan atau andilan tetap dilaksanakan. Wakil Wali Kota Depok, Imam Budi Hartono, dan Ketua Umum Kumpulan Orang Orang Depok (KOOD) Berbudaya, Ahmad Dahlan, turut menyaksikan pemotongan kebo andil tersebut. Ahmad Dahlan menjelaskan bahwa di masa lalu, masyarakat Depok akan melakukan patungan untuk membeli seekor kerbau menjelang Lebaran Idulfitri. Kerbau tersebut kemudian dipotong dan dibagikan kepada mereka yang telah berpartisipasi dalam patungan tersebut, sebagai bagian dari tradisi makan daging kerbau hanya saat Lebaran. Tujuan dari prosesi andil kebo ini adalah untuk mewariskan nilai kebersamaan kepada generasi muda dan mendorong mereka untuk melestarikan budaya tersebut. Ahmad Dahlan juga menegaskan bahwa tradisi memotong kebo andil ini masih dapat dilakukan di berbagai daerah sebelum Lebaran, tidak hanya di Depok, tetapi juga di Jakarta, Tangerang, dan Bekasi."
        )

        beritaArraylist = ArrayList()
        for (i in imageId.indices) {
            val berita = BeritaData(title[i], desc[i], imageId[i])
            beritaArraylist.add(berita)
        }

        // Set the adapter for the ListView
        binding.listView.isClickable = true
        binding.listView.adapter = AdapterBerita(requireActivity(), beritaArraylist)
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val title = title[position]
            val desc = desc[position]
            val imageId = imageId[position]

            val i = Intent(requireActivity(), DetailBerita::class.java)
            i.putExtra("title", title)
            i.putExtra("desc", desc)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }

        // Return the root view of the fragment
        return binding.root
    }
}