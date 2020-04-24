package com.example.rxjava.flowables

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription

class MyFlowables {

      companion object flowables{


          var TAG=javaClass.name
            fun getFlowable() {
                return
            var floaables = Flowable.range(1, 1000000000)
                        .onBackpressureBuffer()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe( object :FlowableSubscriber<Int>{
                            override fun onComplete() {
                            }

                            override fun onSubscribe(s: Subscription) {
                            }

                            override fun onNext(t: Int?) {
                                Log.d(TAG, "onNext: " + t);
                            }

                            override fun onError(t: Throwable?) {
                                Log.e(TAG, "onError: ", t);
                            }

                        })
            }


            

      }
}