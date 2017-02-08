package com.baculsoft.sample.kotlinmvp.views.main

import com.baculsoft.sample.kotlinmvp.model.Data
import com.baculsoft.sample.kotlinmvp.views.base.Presenter

class MainPresenter : Presenter<MainView> {
    private var mView: MainView? = null

    override fun onAttach(view: MainView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun showFragment() {
        // Set Data
        val data: Data = Data("Hello from Data!")

        // Show Fragment with Data
        mView?.onShowFragment(data)
    }
}