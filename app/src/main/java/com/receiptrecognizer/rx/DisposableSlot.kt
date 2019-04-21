package com.receiptrecognizer.rx

import io.reactivex.disposables.Disposable

class DisposableSlot {
    private var disposable: Disposable? = null
    fun replace(disposable: Disposable) {
        dispose()
        this.disposable = disposable
    }

    fun dispose() {
        disposable?.dispose()
        disposable = null
    }
}