package com.baculsoft.sample.kotlinmvp.views.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.baculsoft.sample.kotlinmvp.R
import com.baculsoft.sample.kotlinmvp.model.Data
import com.baculsoft.sample.kotlinmvp.views.next.NextFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        onAttach()
    }

    override fun onAttach() {
        presenter.onAttach(this)
        initToolbar()
        addButtonListener()
    }

    override fun onDetach() {
        presenter.onDetach()
    }

    override fun onShowFragment(data: Data) {
        // Get Data
        val bundle: Bundle = Bundle()
        bundle.putString("data", data.text)

        // Show Fragment with Data
        val tag: String = NextFragment::class.java.simpleName
        val fragment: Fragment = NextFragment().newInstance()
        fragment.arguments = bundle

        // Begin Fragment Transaction
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_main, fragment, tag)
        fragmentTransaction.commit()
    }

    override fun onDestroy() {
        onDetach()
        super.onDestroy()
    }

    private fun initPresenter() {
        presenter = MainPresenter()
    }

    private fun initToolbar() {
        toolbar_main.title = title
        setSupportActionBar(toolbar_main)
    }

    private fun addButtonListener() {
        btn_main.setOnClickListener { view ->
            btn_main.visibility = View.GONE
            presenter.showFragment()
        }
    }
}