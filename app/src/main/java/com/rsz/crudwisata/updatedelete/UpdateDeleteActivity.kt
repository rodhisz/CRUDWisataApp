package com.rsz.crudwisata.updatedelete

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.rsz.crudwisata.R
import com.rsz.crudwisata.model.DataItem
import kotlinx.android.synthetic.main.activity_update_delete.*

class UpdateDeleteActivity : AppCompatActivity() {

    var updateDeletePresenter: UpdateDeletePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete)

        updateDeletePresenter = UpdateDeletePresenter(this)

        // terima data
        val reciveDataWisata = intent.getParcelableExtra<DataItem>("Data")

        // tampilan data
        Glide.with(this)
            .load(reciveDataWisata?.image.toString())
            .error(R.drawable.ic_launcher_background)
            .into(img_update)

        edt_update_kategori.setText(reciveDataWisata?.kategoriId.toString())
        edt_update_harga.setText(reciveDataWisata?.harga.toString())
        edt_update_nama.setText(reciveDataWisata?.namaWisata.toString())
        edt_update_deskripsi.setText(reciveDataWisata?.deskripsi.toString())
        edt_update_kota.setText(reciveDataWisata?.kota.toString())
        edt_update_provinsi.setText(reciveDataWisata?.provinsi.toString())
        edt_update_alamat.setText(reciveDataWisata?.alamat.toString())
        edt_update_waktubuka.setText(reciveDataWisata?.waktuBuka.toString())
        edt_update_latitude.setText(reciveDataWisata?.latitude.toString())
        edt_update_longitude.setText(reciveDataWisata?.longitude.toString())
        edt_update_url.setText(reciveDataWisata?.image.toString())

        // update data
        btn_save.setOnClickListener {
            updateDeletePresenter?.editWisata(
                reciveDataWisata?.id.toString(),
                edt_update_kategori.text.length,
                edt_update_nama?.text.toString(),
                edt_update_harga?.text.toString(),
                edt_update_deskripsi?.text.toString(),
                edt_update_kota?.text.toString(),
                edt_update_provinsi?.text.toString(),
                edt_update_alamat?.text.toString(),
                edt_update_waktubuka?.text.toString(),
                edt_update_latitude?.text.toString(),
                edt_update_longitude?.text.toString(),
                edt_update_url?.text.toString(),
            )
            Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
        }

        btn_delete.setOnClickListener {
            updateDeletePresenter?.deleteWisata(reciveDataWisata?.id.toString())
        }
    }


    fun showMessageUpdate(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun onSuccessUpdate() {
        finish()
    }

    fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showMessageDelete(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun onSuccessDelete() {
        finish()
    }
}