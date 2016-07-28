package com.hypknstudios.dev.threadtimer;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Handler myHandler;
    private boolean gameOn;
    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Milliseconds since the UNIX epoch
        startTime = System.currentTimeMillis();

        myHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                l[l.length - 1]
                if (gameOn) {
                    long seconds = ((System.currentTimeMillis() - startTime)) / 1000;
                    Log.i("info", "seconds =" + seconds);
                }
                myHandler.sendEmptyMessageDelayed(0, 1000);

            }


        };

        gameOn = true;
        myHandler.sendEmptyMessage(0);
    }
}
