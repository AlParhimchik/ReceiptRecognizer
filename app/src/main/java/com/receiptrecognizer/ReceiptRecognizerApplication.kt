package com.receiptrecognizer

import android.app.Application
import com.receiptrecognizer.dagger.AppComponent
import com.receiptrecognizer.dagger.ApplicationModule
import com.receiptrecognizer.dagger.DaggerAppComponent

class ReceiptRecognizerApplication : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        component.inject(this)
    }
}