package com.baculsoft.sample.kotlinmvp.views.main

import com.baculsoft.sample.kotlinmvp.model.Data
import com.baculsoft.sample.kotlinmvp.views.base.View

interface MainView : View {
    fun onShowFragment(data: Data)
}