package com.rsz.crudwisata

interface BasePresenter<T> {
    fun onAttach(view: MainActivity)
    fun onDetach()
}