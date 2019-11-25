package com.example.fortest.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.lifecycle.LiveData;

/**
 * Created by anchaoguang on 2019-11-02.
 */
public class NetworkLiveData extends LiveData<NetworkInfo> {
    private final Context mContext;
    static NetworkLiveData mNetworkLiveData;
    private NetworkReceiver mNetworkReceiver;
    private final IntentFilter mIntentFilter;
    private static final String TAG = "NetworkLiveData";

    public NetworkLiveData(Context context) {
        mContext = context.getApplicationContext();
        mNetworkReceiver = new NetworkReceiver();
        mIntentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
    }

    public static NetworkLiveData getInstance(Context context) {
        if (mNetworkLiveData == null) {
            mNetworkLiveData = new NetworkLiveData(context);
        }
        return mNetworkLiveData;
    }
    // 可以处理，在started 和 resumed
    @Override
    protected void onActive() {
        Log.d(TAG, "onActive:");
        mContext.registerReceiver(mNetworkReceiver, mIntentFilter);
        super.onActive();
    }

    // 无法处理，可能不在 started 和 resumed
    @Override
    protected void onInactive() {
        Log.d(TAG, "onInactive: ");
        mContext.unregisterReceiver(mNetworkReceiver);
        super.onInactive();
    }

    private static class NetworkReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
            getInstance(context).setValue(activeNetwork);

        }
    }
}
