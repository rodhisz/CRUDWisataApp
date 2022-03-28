package com.rsz.crudwisata.create

import com.rsz.crudwisata.MainActivity
import com.rsz.crudwisata.model.ResponseWisata
import com.rsz.crudwisata.api.ApiConfig
import com.rsz.crudwisata.base.BasePresenter
import com.rsz.crudwisata.updatedelete.UpdateDeleteConstruct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var mainView: MainActivity) : BasePresenter<MainConstruct.view>,
    MainConstruct.Presenter {
    override fun onAttach(view: MainActivity) {
        mainView = view
    }

    override fun onDetach() {
        mainView
    }

    override fun getAllWisata() {
        ApiConfig.getService().getWisata().enqueue(object : Callback<ResponseWisata> {
            override fun onResponse(
                call: Call<ResponseWisata>,
                response: Response<ResponseWisata>
            ) {
                if (response.isSuccessful || response.code() == 200) {
                    val msg = response.body()?.message
                    val sukses = response.body()?.message

                    if (sukses != null) {
                        val dataWisata = response?.body()?.data
                        mainView?.showDataWisata(dataWisata)
                    } else {
                        mainView?.showMessage(msg.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ResponseWisata>, t: Throwable) {
                mainView?.showError(t.message.toString())
            }

        })
    }

    override fun insertWisata(
        kategoriId: String,
        namaWisata: String,
        harga: String,
        deskripsi: String,
        kota: String,
        provinsi: String,
        alamat: String,
        waktu_buka: String,
        latitude: String,
        longitude: String,
        image: String
    ) {
        ApiConfig.getService().InsertDataFood(
            kategoriId,
            namaWisata,
            harga,
            deskripsi,
            kota,
            provinsi,
            alamat,
            waktu_buka,
            latitude,
            longitude,
            image
        ).enqueue(object : Callback<ResponseWisata> {

            override fun onResponse(
                call: Call<ResponseWisata>,
                response: Response<ResponseWisata>
            ) {
                if (response.isSuccessful || response.code() == 200) {
                    val msg = response.body()?.message
                    val sukses = response.body()?.status

                    if (sukses != null) {
                        mainView?.onSuccessInsert()
                        mainView?.showMessage(msg.toString())
                    } else {
                        mainView?.showMessage(msg.toString())
                    }

                }
            }

            override fun onFailure(call: Call<ResponseWisata>, t: Throwable) {
                mainView?.showError(t.message.toString())
            }

        })
    }

    override fun onAttach(view: UpdateDeleteConstruct) {
        TODO("Not yet implemented")
    }

}


