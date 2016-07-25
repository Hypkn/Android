package com.hypknstudios.aworkingmethod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("info", "I am in the onCreate method");
        if(guessANumber(1,2,3)){
            Log.i("info", "Found It!");
        } else{
            Log.i("info", "Can't find it!");
        }

        Log.i("info", "Back in onCreate");
    }

    boolean guessANumber(int try1, int try2 , int try3 ){
        //All log i lines print to the android console
        Log.i("info", "Hi there , I am in the method body");
        Log.i("info", "try1 = " + try1);
        Log.i("info", "try2 = " + try2);
        Log.i("info", "try3 = " + try3);

        boolean found = false;

        Random randInt = new Random();
        int randNum = randInt.nextInt(6);

        Log.i("info", "Our random number = " + randNum);

        //Check if guesses are the same as randNum
        if(try1 == randNum || try2 == randNum || try3 == randNum) {
            found = true;
            Log.i("info", "aha!");
        }else {
            Log.i("info", "hmmm");

        }
        return found;
    }
}
