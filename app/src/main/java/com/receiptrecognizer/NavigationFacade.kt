package com.receiptrecognizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.receiptrecognizer.views.details.DetailsFragment
import com.receiptrecognizer.views.home.MainScreenFragment
import javax.inject.Inject
import kotlin.reflect.KClass

class NavigationFacade @Inject constructor() {
    fun goToHomeScreen(activity: Activity) {
       startActivityIntent(activity, MainScreenFragment::class)
    }

    fun goToDetailsScreen(activity: Activity) {
        startActivityIntent(activity, DetailsFragment::class)
    }

    companion object {
        fun startActivityIntent(activity: Activity,
                                fragment: KClass<out Fragment>,
                                bundle: Bundle = Bundle()) {
            val intent = Intent(activity, MainActivity::class.java)

            intent.putExtra(MainActivity.EXTRA_NAVIGATION_COMMAND, fragment.java)
            intent.putExtra(MainActivity.EXTRA_NAVIGATION_BUNDLE, bundle)

            activity.startActivity(intent)
        }
    }

}