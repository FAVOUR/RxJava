package com.example.rxjava.operators

import android.util.Log
import com.example.rxjava.model.DataSource
import com.example.rxjava.model.Task
import com.example.rxjava.observables.Observables
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class operators {

    companion object{
        fun createOperators(){
            var createSingleObservable = Observable.create(object :ObservableOnSubscribe<String>{
                override fun subscribe(emitter: ObservableEmitter<String>) {
                    if(!emitter.isDisposed){
                        emitter.onNext("Here we go")
                        emitter.onComplete()
                    }

                }
            })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getStringObserver())



            var createListObservables = Observable.create(ObservableOnSubscribe<Task> { emiter ->
                if(!emiter.isDisposed){
                    for (tasks in DataSource().createTasksList()!!){
                          emiter.onNext(tasks)
                            emiter.onComplete()
                    }
                }else{
                         emiter.isDisposed
                }
            }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Observables.generateTaskObserver())


        }



        fun getStringObserver():Observer<String>{
             return object :  Observer<String> {
                 override fun onComplete() {
                 }

                 override fun onSubscribe(d: Disposable) {
                 }

                 override fun onNext(t: String) {
                     Log.i("value", t)
                 }

                 override fun onError(e: Throwable) {
                 }
             }
        }

        fun getIntObserver():Observer<Int>{
            return object :  Observer<Int> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: Int) {
                    Log.i("value", t.toString())
                }

                override fun onError(e: Throwable) {
                }
            }
        }



    }
}