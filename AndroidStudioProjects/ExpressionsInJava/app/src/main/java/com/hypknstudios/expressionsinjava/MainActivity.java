package com.hypknstudios.expressionsinjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declared and initialize variables
        int a = 10;
        a++;
        a = a + 10;

        String b = "Alan Turing";
        b = b + " was smarter than the average bear";

        boolean c = true;
        c = (1 + 1 ==3);
        Log.i("info", "a = " + a);
        Log.i("info", "b = " + b);
        Log.i("info", "c = " + c);

    }
}
