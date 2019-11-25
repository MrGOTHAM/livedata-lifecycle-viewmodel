package com.example.fortest.liveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fortest.model.ScoreModel

/**
 * Created by anchaoguang on 2019-11-01.
 *
 */
class LiveDataViewModel : ViewModel(){

    private val  mCurrentScore by lazy { MutableLiveData<ScoreModel>() }
    private val mLastScore by lazy { MutableLiveData<ScoreModel>() }

    fun getCurrentScoreByScoreId(scoreId: String, score: Int): MutableLiveData<ScoreModel> {
        if (mCurrentScore.value != null && !mCurrentScore.value!!.scoreId.isNullOrEmpty()){
            mLastScore.value = ScoreModel(mCurrentScore.value!!.scoreId, mCurrentScore.value!!.score)
        }
        mCurrentScore.value = ScoreModel(scoreId, score)
        return mCurrentScore
    }

    fun getCurrentScoreByScoreId(scoreId: String): MutableLiveData<ScoreModel> {
        val initData by lazy { MutableLiveData<ScoreModel>() }
        initData.value = ScoreModel("",0)

        if (mCurrentScore.value == null ||  mCurrentScore.value!!.scoreId.isNullOrEmpty()){
            return initData
        }

        if (scoreId == mCurrentScore.value!!.scoreId){
            return mCurrentScore
        }
        return mLastScore
    }
    // 调用时机
    override fun onCleared() {
        super.onCleared()
        // 清除不必要的请求
    }
}