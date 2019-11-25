package com.example.fortest.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * Created by anchaoguang on 2019-10-31.
 *
 */
class ActivityLifeObserver : LifecycleObserver{
    private var TAG = "ActivityLifeObserver "

    constructor(TAG: String):super(){
        this.TAG = TAG
    }

    constructor()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.i(TAG, "onCreate()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.i(TAG, "onStart()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.i(TAG, "onResume()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        Log.i(TAG, "onPause()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        Log.i(TAG, "onStop()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.i(TAG, "onDestroy()")
    }

//    执行每一个生命周期，它都会被执行到。可以用来匹配所有事件
//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    fun onAny(){
//        Log.i(TAG, "这是Any")
//    }
}