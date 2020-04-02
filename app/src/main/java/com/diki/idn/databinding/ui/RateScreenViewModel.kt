package com.diki.idn.databinding.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.diki.idn.databinding.R
import com.diki.idn.databinding.data.RateLiveDataViewModel
import com.diki.idn.databinding.databinding.RateScreenBindingImpl

class RateScreenViewModel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val rateViewModel = ViewModelProviders.of(this).get(RateLiveDataViewModel::class.java)

        val bindingLayout: RateScreenBindingImpl =
            DataBindingUtil.setContentView(this, R.layout.rate_screen)
        bindingLayout.viewModel = rateViewModel
        bindingLayout.lifecycleOwner = this
    }
}