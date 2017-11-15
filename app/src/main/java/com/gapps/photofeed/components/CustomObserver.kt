package com.gapps.photofeed.components

import io.reactivex.observers.DisposableObserver

open class CustomObserver<T> : DisposableObserver<T>() {
    override fun onError(exception: Throwable) {}
    override fun onNext(data: T) {}
    override fun onComplete() {}
}