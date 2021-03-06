package com.receiptrecognizer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.receiptrecognizer.dagger.ActivityScopeModule
import com.receiptrecognizer.extensions.replace
import javax.inject.Inject


class NavigationActivity : AppCompatActivity() {
    val component by lazy { app.component.setActivityModule(ActivityScopeModule(this)) }

    private val app: ReceiptRecognizerApplication
        get() = application as? ReceiptRecognizerApplication ?: throw IllegalStateException("Expected ReceiptRecognizerApplication here")

    @Inject
    lateinit var navigationFacade: NavigationFacade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        setContentView(R.layout.activity_main)

        handleIntent(savedInstanceState)
    }

    private fun handleIntent(savedInstanceState: Bundle?) {
        if (isFinishing || isDestroyed) {
            return
        }

        if (savedInstanceState == null) {
            if (intent.hasExtra(EXTRA_NAVIGATION_COMMAND)) {
                showFragment((intent.getSerializableExtra(EXTRA_NAVIGATION_COMMAND) as Class<*>).name,
                             intent.getBundleExtra(EXTRA_NAVIGATION_BUNDLE))
            } else {
                navigationFacade.goToHomeScreen(activity = this)
            }
        }
    }

    private fun showFragment(fragmentName: String, arguments: Bundle) {
        supportFragmentManager.replace(R.id.fragmentFrame,
                                       Fragment.instantiate(this, fragmentName, arguments),
                                       fragmentName)
    }

    companion object {
        const val EXTRA_NAVIGATION_COMMAND = "navigationCommand"
        const val EXTRA_NAVIGATION_BUNDLE = "navigationBundle"

    }
}