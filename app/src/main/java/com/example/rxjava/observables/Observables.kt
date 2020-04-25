package com.example.rxjava.observables

import android.util.Log
import com.example.rxjava.model.DataSource
import com.example.rxjava.model.Task
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Observables {

    companion object{
        fun genereateObservable(){
//         var observable:Observable<Task> = Observable.fromIterable(createTasksList())

            //Three ways to implement and interface in kotlin
            var observable = Observable.create<String>{ it.onNext("") }
            var observable_ = Observable.create(object : ObservableOnSubscribe<String>{
                override fun subscribe(emitter: ObservableEmitter<String>) {
                    emitter.onNext("")
                }
            })

            var observable__ = Observable.create(ObservableOnSubscribe<String> { emitter -> emitter.onNext("") })

            var thread = Thread()
        Observable.fromIterable(DataSource().createTasksList())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(generateTaskObserver())

        }

         fun generateTaskObserver():Observer<Task>{
           return object:Observer<Task>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: Task) {

                    Log.i("Tasks", t.toString())
                }

                override fun onError(e: Throwable) {
                }
            }
        }
    }
}