package com.example.fortest.liveData

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fortest.R
import com.example.fortest.model.ScoreModel
import com.example.fortest.net.NetActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by anchaoguang on 2019-11-01.
 *
 */
class LiveDataActivity : AppCompatActivity(){
    // 获取ViewModel实例
    private val mViewModel  by lazy { ViewModelProviders.of(this).get(LiveDataViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ab_add_button.visibility = View.VISIBLE

        val initNum = Observer<ScoreModel> {
            when {
                it.scoreId == "scoreA" -> scoreA_textView.text = it.score.toString()
                it.scoreId == "scoreB" -> scoreB_textView.text = it.score.toString()
                else -> {
                    scoreA_textView.text = it.score.toString()
                    scoreB_textView.text = it.score.toString()
                }
            }
        }

        mViewModel.getCurrentScoreByScoreId("scoreA").observe(this, initNum)
        mViewModel.getCurrentScoreByScoreId("scoreB").observe(this, initNum)

        ab_jump_button.text = "跳到MainActivity"
        ab_jump_button.setOnClickListener {
            val intent = Intent(this, NetActivity::class.java)
            startActivity(intent)
        }
        doAdd()
    }

    private fun doAdd(){
        ab_add_button.setOnClickListener {
            //创建更新UI的观察者
            val addNum = Observer<ScoreModel>{
                if (it.scoreId == "scoreA") {
                    scoreA_textView.text = it.score.toString()
                } else if (it.scoreId == "scoreB") {
                    scoreB_textView.text = it.score.toString()
                }
            }
            val scoreA: Int = scoreA_textView.text.toString().toInt() + 1
            val scoreB: Int = scoreB_textView.text.toString().toInt() + 2
            //观察LiveData
            mViewModel.getCurrentScoreByScoreId("scoreA", scoreA).observe(this, addNum)
            mViewModel.getCurrentScoreByScoreId("scoreB", scoreB).observe(this, addNum)
        }
    }

    override fun onDestroy() {
        Toast.makeText(this,"正在重建哦！", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}