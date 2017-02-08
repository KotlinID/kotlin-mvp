package com.baculsoft.sample.kotlinmvp.views.base

interface Presenter<in T : View> {
    fun onAttach(view: T)

    fun onDetach()
}