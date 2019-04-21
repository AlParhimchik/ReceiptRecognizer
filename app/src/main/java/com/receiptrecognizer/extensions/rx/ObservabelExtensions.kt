package com.receiptrecognizer.extensions.rx

import io.reactivex.Maybe
import io.reactivex.Observable

fun <T : Any, R : Any> Observable<T>.mapNotNull(mapper: (T) -> R?): Observable<R> =
    flatMapMaybe { Maybe.fromCallable<R> { mapper.invoke(it) } }