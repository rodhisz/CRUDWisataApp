package com.rsz.crudwisata.api

import com.rsz.crudwisata.model.ResponseWisata
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("wisata")
    fun getWisata() : Call<ResponseWisata>

    @FormUrlEncoded
    @POST("add-wisata")
    fun InsertDataFood(
        @Field("kategori_id") kategoriId: String,
        @Field("nama_wisata") namaWisata: String,
        @Field("harga") harga: String,
        @Field("deskripsi") deskripsi: String,
        @Field("kota") kota: String,
        @Field("provinsi") provinsi: String,
        @Field("alamat") alamat: String,
        @Field("waktu_buka") waktu_buka: String,
        @Field("latitude") latitude: String,
        @Field("longitude") longitude: String,
        @Field("image") image: String,
    ): Call<ResponseWisata>

}