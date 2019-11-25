package com.example.fortest.lifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.example.fortest.R
import com.example.fortest.viewModel.CourtCountActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by anchaoguang on 2019-11-01.
 *
 */
class Main2Activity :Activity(), LifecycleOwner{

    private val mLifecycleRegistry: LifecycleRegistry by lazy { LifecycleRegistry(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scoreA_textView.visibility = View.GONE
        scoreB_textView.visibility = View.GONE

        mLifecycleRegistry.markState(Lifecycle.State.CREATED)
        lifecycle.addObserver(ActivityLifeObserver("Main2Activity"))

        ab_jump_button.text = "跳到CourtCount"
        ab_jump_button.setOnClickListener {
            val intent = Intent(this, CourtCountActivity::class.java)
            startActivity(intent)
        }
    }
    // 没有onPause() 和 onStop()

    override fun onStart() {
        super.onStart()
        mLifecycleRegistry.markState(Lifecycle.State.STARTED)
    }
    override fun onResume() {
        super.onResume()
        mLifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }
    override fun onDestroy() {
        super.onDestroy()
        mLifecycleRegistry.markState(Lifecycle.State.DESTROYED)
        lifecycle.removeObserver(ActivityLifeObserver())
    }
    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }
}