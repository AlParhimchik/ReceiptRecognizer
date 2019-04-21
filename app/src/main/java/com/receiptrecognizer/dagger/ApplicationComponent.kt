package com.receiptrecognizer.dagger

import com.receiptrecognizer.ReceiptRecognizerApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface AppComponent {
    fun inject(application: ReceiptRecognizerApplication)

    fun setActivityModule(activityScopeModule: ActivityScopeModule): ActivityComponent
}