package com.rsz.crudwisata

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsz.crudwisata.model.DataItem
import com.rsz.crudwisata.create.MainPresenter
import com.rsz.crudwisata.create.WisataAdapter
import com.rsz.crudwisata.updatedelete.UpdateDeletePresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_row_wisata.*

class MainActivity : AppCompatActivity() {

    var mainPresenter : MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        mainPresenter?.getAllWisata()
    }

    fun showDataWisata(dataWisata: List<DataItem?>?) {
        val adapterWisata = WisataAdapter(dataWisata, this)

        rv_wisata.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = adapterWisata
        }
    }

    fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun onAttachView() {
        mainPresenter?.onAttach(this)
    }

    private fun onDetachView() {
        mainPresenter?.onDetach()
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDetachView()
    }

    override fun onResume() {
        super.onResume()
        mainPresenter?.getAllWisata()
    }

    fun onSuccessInsert() {
        mainPresenter?.getAllWisata()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_add -> {
                insertDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDialog() {
        val alert = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_insert, null)
        alert.setView(view)
        alert.setCancelable(false)
        alert.setTitle("Add New Wisata")
        alert.setPositiveButton(
            "Save",
            DialogInterface.OnClickListener { dialogInterface, i ->
                val kategoriId = view.findViewById<EditText>(R.id.edt_kategori_id)
                val namaWisata = view.findViewById<EditText>(R.id.edt_nama_wisata)
                val harga = view.findViewById<EditText>(R.id.edt_harga)
                val deskripsi = view.findViewById<EditText>(R.id.edt_deskripsi)
                val kota = view.findViewById<EditText>(R.id.edt_kota)
                val provinsi = view.findViewById<EditText>(R.id.edt_provinsi)
                val alamat = view.findViewById<EditText>(R.id.edt_alamat)
                val waktuBuka = view.findViewById<EditText>(R.id.edt_waktu_buka)
                val latitue = view.findViewById<EditText>(R.id.edt_latitude)
                val longLatitude = view.findViewById<EditText>(R.id.edt_long_latitue)
                val image = view.findViewById<EditText>(R.id.edt_img)

                mainPresenter?.insertWisata(
                    kategoriId.text.toString(),
                    namaWisata.text.toString(),
                    harga.text.toString(),
                    deskripsi.text.toString(),
                    kota.text.toString(),
                    provinsi.text.toString(),
                    alamat.text.toString(),
                    waktuBuka.text.toString(),
                    latitue.text.toString(),
                    longLatitude.text.toString(),
                    image.text.toString(),

                    )
                dialogInterface.dismiss()
            })
        alert.setNeutralButton("close", DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() })
        alert.show()
    }

}