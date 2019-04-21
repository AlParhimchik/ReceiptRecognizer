package com.receiptrecognizer.dagger

import com.receiptrecognizer.MainActivity
import com.receiptrecognizer.views.details.DetailsFragment
import com.receiptrecognizer.views.home.MainScreenFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityScopeModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)

    fun inject(homeFragment: MainScreenFragment)
    fun inject(DetailsFragment: DetailsFragment)
}