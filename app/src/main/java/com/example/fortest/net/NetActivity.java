package com.example.fortest.net;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fortest.R;
import com.example.fortest.lifecycle.MainActivity;

/**
 * Created by anchaoguang on 2019-11-02.
 */
public class NetActivity extends AppCompatActivity {
    private static final String TAG = "NetActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button jumpButton = findViewById(R.id.ab_jump_button);
        jumpButton.setOnClickListener(v->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        NetworkLiveData.getInstance(this).observe(this, networkInfo ->
                Log.d(TAG, "onChanged: networkInfo=" +networkInfo));
    }
}
