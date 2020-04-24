package com.example.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjava.observables.Observables

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Observables
        Observables.genereateObservable()
    }
}
