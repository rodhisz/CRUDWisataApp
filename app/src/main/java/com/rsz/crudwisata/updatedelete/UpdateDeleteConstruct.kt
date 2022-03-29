package com.rsz.crudwisata.updatedelete

import com.rsz.crudwisata.base.BaseView

interface UpdateDeleteConstruct {

    interface view : BaseView {
        fun showMessageUpdate(msg: String)
        fun showMessageDelete(msg: String)
        fun showError(error: String)
        fun onSuccessDelete()
        fun onSuccessUpdate()
    }

    interface Presenter {
        fun editWisata(
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
        )

        fun deleteWisata(idWisata: String)

    }
}