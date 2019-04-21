package com.receiptrecognizer.dagger

import com.receiptrecognizer.NavigationActivity
import com.receiptrecognizer.views.details.DetailsFragment
import com.receiptrecognizer.views.home.HomeFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityScopeModule::class])
interface ActivityComponent {
    fun inject(activity: NavigationActivity)

    fun inject(homeFragment: HomeFragment)
    fun inject(DetailsFragment: DetailsFragment)
}