package com.example.rxjava.observables

import android.util.Log
import com.example.rxjava.model.Task
import com.example.rxjava.model.createTasksList
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Observables {

    companion object{
        fun genereateObservable(){
//         var observable:Observable<Task> = Observable.fromIterable(createTasksList())
        Observable.fromIterable(createTasksList())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(generateObserver())
        }

        private fun generateObserver():Observer<Task>{
           return object:Observer<Task>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: Task) {

                    Log.i("Tasks",)
                }

                override fun onError(e: Throwable) {
                }
            }
        }
    }
}