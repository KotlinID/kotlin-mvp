package com.baculsoft.sample.kotlinmvp.views.next

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.baculsoft.sample.kotlinmvp.R
import kotlinx.android.synthetic.main.fragment_next.*

class NextFragment : Fragment(), NextView {
    lateinit var presenter: NextPresenter

    fun newInstance(): NextFragment {
        return NextFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initPresenter()
        onAttach()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_next, container, false)
    }

    override fun onAttach() {
        presenter.onAttach(this)
        setText()
    }

    override fun onDetach() {
        presenter.onDetach()
        super.onDetach()
    }

    override fun onShowResult(text: String) {
        tv_next.text = text
    }

    override fun onDestroyView() {
        onDetach()
        super.onDestroyView()
    }

    private fun initPresenter() {
        presenter = NextPresenter()
    }

    private fun setText() {
        val bundle: Bundle = arguments
        val text: String = bundle.getString("data")

        presenter.showText(text)
    }
}