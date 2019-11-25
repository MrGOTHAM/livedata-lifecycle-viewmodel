package com.example.fortest.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import com.example.fortest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mActivityLifeObserver: ActivityLifeObserver by lazy { ActivityLifeObserver("MainActivity") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scoreA_textView.visibility = View.GONE
        scoreB_textView.visibility = View.GONE

        lifecycle.addObserver(mActivityLifeObserver)
        ab_jump_button.text = "跳转到Main2Activity"
        ab_jump_button.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
            lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mActivityLifeObserver)
    }
}
