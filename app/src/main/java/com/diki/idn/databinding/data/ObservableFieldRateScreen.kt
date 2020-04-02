package com.diki.idn.databinding.data

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableInt
import com.diki.idn.databinding.data.RateObservableField

class ObservableFieldRateScreen : AppCompatActivity() {
    private val observableFieldRate =
        RateObservableField(like = ObservableInt(0), dislike = ObservableInt(0))

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}