package com.hypknstudios.dev.persistence;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String dataName = "MyData";
    String stringName = "MyString";
    String defaultString = ":-(";
    String currentString = " ";
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize our two SharedPreferences objects
        prefs = getSharedPreferences(dataName, MODE_PRIVATE);
        editor = prefs.edit();

        //Either load our string or
        //set to default string
        currentString = prefs.getString(stringName, defaultString);

        button1 = (Button) findViewById(R.id.centerButton);

        //Listen for clicks
        button1.setOnClickListener(this);

        button1.setText(currentString);
    }

    @Override
    public void onClick(View view) {

        //No switch as only one button

        Random randInt = new Random();
        int ourRandom = randInt.nextInt(10);

        //Add random number to end of currentString
        currentString = currentString + ourRandom;

        //Saves currentString to a file in case the user
        //suddenly quits or gets a phone call

        editor.putString(stringName, currentString);
        editor.commit();

        //update button text
        button1.setText(currentString);

    }
}
