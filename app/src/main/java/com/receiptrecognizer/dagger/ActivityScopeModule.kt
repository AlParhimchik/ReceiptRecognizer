package com.receiptrecognizer.dagger

import android.app.Activity
import com.receiptrecognizer.MainActivity
import dagger.Module
import dagger.Provides


@Module
class ActivityScopeModule(private val activity: MainActivity) {
    @Provides
    @ActivityScope
    internal fun providesActivity(): Activity = activity
}