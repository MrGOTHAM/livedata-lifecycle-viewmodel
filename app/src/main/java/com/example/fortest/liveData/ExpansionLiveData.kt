package com.example.fortest.liveData

import androidx.lifecycle.LiveData
import com.example.fortest.model.ScoreModel
import java.math.BigDecimal

/**
 * Created by anchaoguang on 2019-11-01.
 *
 */
class ExpansionLiveData(symbol: String): LiveData<ScoreModel>() {





    override fun onInactive() {
        super.onInactive()
    }

    override fun onActive() {
        super.onActive()
    }
}