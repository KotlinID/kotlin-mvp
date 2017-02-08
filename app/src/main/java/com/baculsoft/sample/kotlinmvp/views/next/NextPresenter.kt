package com.baculsoft.sample.kotlinmvp.views.next

import com.baculsoft.sample.kotlinmvp.views.base.Presenter

class NextPresenter : Presenter<NextView> {
    private var mView: NextView? = null

    override fun onAttach(view: NextView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun showText(text: String) {
        mView?.onShowResult(text)
    }
}