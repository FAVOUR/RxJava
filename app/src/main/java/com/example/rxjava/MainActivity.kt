package com.example.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjava.flowables.MyFlowables
import com.example.rxjava.observables.Observables
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Observables
        Observables.genereateObservable()

        //Flowables note that Flowables is an observable but the difference is that flowable was added because of backpressure
        //(Backpressure is when in a Flowable processing pipeline can't process the values fast enough and need a way to tell the upstream producer to slow down.)
        //There fore there need to be a strategy in this example I am using the backpressurebuffer Strategy

          MyFlowables.getFlowable()
        }
}
