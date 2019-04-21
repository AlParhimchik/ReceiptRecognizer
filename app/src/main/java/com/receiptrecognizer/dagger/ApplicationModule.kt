package com.receiptrecognizer.dagger

import com.receiptrecognizer.ReceiptRecognizerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: ReceiptRecognizerApplication) {
    @Provides
    @Singleton
    fun provideApplication(): ReceiptRecognizerApplication = app
}