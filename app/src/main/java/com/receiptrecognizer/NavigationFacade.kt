package com.receiptrecognizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.receiptrecognizer.views.details.DetailsFragment
import com.receiptrecognizer.views.home.HomeFragment
import javax.inject.Inject
import kotlin.reflect.KClass

class NavigationFacade @Inject constructor() {
    fun goToHomeScreen(activity: Activity) {
       startActivityIntent(activity, HomeFragment::class)
    }

    fun goToDetailsScreen(activity: Activity) {
        startActivityIntent(activity, DetailsFragment::class)
    }

    companion object {
        fun startActivityIntent(activity: Activity,
                                fragment: KClass<out Fragment>,
                                bundle: Bundle = Bundle()) {
            val intent = Intent(activity, NavigationActivity::class.java)

            intent.putExtra(NavigationActivity.EXTRA_NAVIGATION_COMMAND, fragment.java)
            intent.putExtra(NavigationActivity.EXTRA_NAVIGATION_BUNDLE, bundle)

            activity.startActivity(intent)
        }
    }

}