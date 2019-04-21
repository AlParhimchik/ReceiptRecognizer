package com.receiptrecognizer.extensions

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

fun FragmentManager.replace(@IdRes fragmentFrame: Int,
                            fragment: Fragment,
                            name: String) {
    beginTransaction()
            .replace(fragmentFrame,
                     fragment,
                     name)
        .commitAllowingStateLoss()
}
