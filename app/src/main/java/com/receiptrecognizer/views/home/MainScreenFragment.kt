package com.receiptrecognizer.views.home

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.jakewharton.rxbinding3.view.clicks
import com.receiptrecognizer.MainActivity
import com.receiptrecognizer.NavigationFacade
import com.receiptrecognizer.R
import com.receiptrecognizer.rx.DisposableSlot
import com.receiptrecognizer.rx.extensions.mapNotNull
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MainScreenFragment : Fragment() {

    @BindView(R.id.go_to_details_button)
    lateinit var goToDetailsButton: TextView

    @Inject
    lateinit var navigationFacade: NavigationFacade

    private val disposableSlot = DisposableSlot()

    private val observer = object : LifecycleObserver{
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun start() {
            disposableSlot.replace(
                goToDetailsButton.clicks()
                    .mapNotNull { activity }
                    .subscribeBy(onNext = navigationFacade::goToDetailsScreen)
            )
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun stop() {
            disposableSlot.dispose()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(observer)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)

        val activity = activity as MainActivity
        activity.component.inject(this)

        lifecycle.addObserver(observer)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.home_screen_layout, container, false)
}