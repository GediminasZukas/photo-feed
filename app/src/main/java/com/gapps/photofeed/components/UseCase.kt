package com.gapps.photofeed.components

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

@Suppress("UNCHECKED_CAST")
abstract class UseCase<T, in Params> {

    private var disposables: CompositeDisposable = CompositeDisposable()

    fun execute(observer: DisposableObserver<T>, params: Params = "" as Params) {
        val observable: Observable<T> = buildUseCaseObservable(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        addDisposable(observable.subscribeWith(observer))
    }

    abstract fun buildUseCaseObservable(params: Params): Observable<T>

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        if (disposables.isDisposed) {
            disposables = CompositeDisposable()
        }
        disposables.add(disposable)
    }
}