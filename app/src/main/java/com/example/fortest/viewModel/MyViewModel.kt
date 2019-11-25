package com.example.fortest.viewModel

import androidx.lifecycle.ViewModel

/**
 * Created by anchaoguang on 2019-11-01.
 *
 */
class MyViewModel : ViewModel(){

    var scoreTeamB = 0
    var scoreTeamA = 0

    // 调用时机
    override fun onCleared() {
        super.onCleared()
        // 清除不必要的请求
    }
}