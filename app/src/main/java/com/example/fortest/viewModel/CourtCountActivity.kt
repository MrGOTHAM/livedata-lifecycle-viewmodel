package com.example.fortest.viewModel

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.fortest.R
import com.example.fortest.liveData.LiveDataActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by anchaoguang on 2019-11-01.
 *
 */
class CourtCountActivity : AppCompatActivity() {

    private val mViewModel  by lazy { ViewModelProviders.of(this).get(MyViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ab_add_button.visibility = View.VISIBLE

        displayForTeamA(mViewModel.scoreTeamA)
        displayForTeamB(mViewModel.scoreTeamB)

        ab_add_button.setOnClickListener {
            mViewModel.scoreTeamA = mViewModel.scoreTeamA + 1
            displayForTeamA(mViewModel.scoreTeamA)
            mViewModel.scoreTeamB = mViewModel.scoreTeamB + 2
            displayForTeamB(mViewModel.scoreTeamB)
        }

        ab_jump_button.text = "跳到LiveDataActivity"
        ab_jump_button.setOnClickListener {
            val intent = Intent(this, LiveDataActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displayForTeamA(scoreA : Int){
        scoreA_textView.text = scoreA.toString()
    }

    private fun displayForTeamB(scoreB : Int){
        scoreB_textView.text = scoreB.toString()
    }

    override fun onDestroy() {
        Toast.makeText(this,"正在重建哦！",Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}