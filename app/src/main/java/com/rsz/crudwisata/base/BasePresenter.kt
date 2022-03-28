package com.rsz.crudwisata.base

import com.rsz.crudwisata.MainActivity
import com.rsz.crudwisata.updatedelete.UpdateDeleteConstruct

interface BasePresenter<T> {
    fun onAttach(view: MainActivity)
    fun onDetach()
    fun onAttach(view: UpdateDeleteConstruct)
}