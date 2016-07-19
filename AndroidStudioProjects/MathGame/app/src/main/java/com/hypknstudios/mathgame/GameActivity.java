package com.hypknstudios.mathgame;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Loads UI design to screen
        setContentView(R.layout.activity_game);

        //Variables initialization
        int partA = 9;
        int partB = 9;
        int correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;
    } //onCreate ends here

    /* Here is a working object based on either the button
    or TextView class and base as well as link our new object
     */
}
