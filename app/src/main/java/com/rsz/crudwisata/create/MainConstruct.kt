package com.rsz.crudwisata.create

interface MainConstruct {
    interface view{
    }

    interface Presenter{
        fun getAllWisata()
        fun insertWisata(
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
            image: String,
        )
    }
}