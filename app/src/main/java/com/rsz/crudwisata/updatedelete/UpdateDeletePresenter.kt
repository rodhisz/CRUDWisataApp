package com.rsz.crudwisata.updatedelete

import com.rsz.crudwisata.MainActivity
import com.rsz.crudwisata.api.ApiConfig
import com.rsz.crudwisata.base.BasePresenter
import com.rsz.crudwisata.model.ResponseWisata
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateDeletePresenter(var updateDeleteView: UpdateDeleteActivity) :
    BasePresenter<UpdateDeleteConstruct.view>, UpdateDeleteConstruct.Presenter {
    override fun onAttach(view: MainActivity) {
        TODO("Not yet implemented")
    }

    override fun onDetach() {
        updateDeleteView
    }

    override fun onAttach(view: UpdateDeleteConstruct) {
        updateDeleteView
    }

    override fun editWisata(
        idWisata: String,
        katWisata: Int,
        nameWisata: String,
        priceWisata: String,
        descWisata: String,
        cityWisata: String,
        provinceWisata: String,
        addressWisata: String,
        openWisata: String,
        latWisata: String,
        longWisata: String,
        imgWisata: String
    ) {
        ApiConfig.getService().editWisata(
            idWisata,
            katWisata,
            nameWisata,
            priceWisata,
            descWisata,
            cityWisata,
            provinceWisata,
            addressWisata,
            openWisata,
            latWisata,
            longWisata,
            imgWisata
        ).enqueue(object :
            Callback<ResponseWisata> {
            override fun onResponse(
                call: Call<ResponseWisata>,
                response: Response<ResponseWisata>
            ) {
                if (response.isSuccessful || response.code() == 200) {
                    val msg = response.body()?.message
                    val sukses = response.body()?.status

                    if (sukses != null) {
                        val dataWisata = response.body()?.data
                        updateDeleteView?.showMessageUpdate(msg.toString())
                        updateDeleteView?.onSuccessUpdate()
                    } else {
                        updateDeleteView?.showMessageUpdate(msg.toString())
                    }

                }
            }

            override fun onFailure(call: Call<ResponseWisata>, t: Throwable) {
                updateDeleteView?.showError(t.localizedMessage.toString())
            }

        })
    }

    override fun deleteWisata(idWisata: String) {
        ApiConfig.getService().deleteWisata(
            idWisata
        ).enqueue(object :
            Callback<ResponseWisata> {
            override fun onResponse(
                call: Call<ResponseWisata>,
                response: Response<ResponseWisata>
            ) {
                if (response.isSuccessful || response.code() == 200) {
                    val msg = response.body()?.message
                    val sukses = response.body()?.status

                    if (sukses != null) {
                        updateDeleteView?.showMessageDelete(msg.toString())
                        updateDeleteView?.onSuccessDelete()
                    } else {
                        updateDeleteView?.showMessageDelete(msg.toString())
                    }

                }
            }

            override fun onFailure(call: Call<ResponseWisata>, t: Throwable) {
                updateDeleteView?.showError(t.localizedMessage.toString())
            }

        })
    }

}