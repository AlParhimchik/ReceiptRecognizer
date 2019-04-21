package com.receiptrecognizer.dagger

import android.app.Activity
import com.receiptrecognizer.NavigationActivity
import dagger.Module
import dagger.Provides


@Module
class ActivityScopeModule(private val activity: NavigationActivity) {
    @Provides
    @ActivityScope
    internal fun providesActivity(): Activity = activity
}