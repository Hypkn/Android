package com.hypknstudios.mathgame;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    int correctAnswer;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Loads UI design to screen
        setContentView(R.layout.activity_game);

        //Variables initialization
        int partA = 9;
        int partB = 9;
        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;

/* Here is a working object based on either the button
    or TextView class and base as well as link our new object
     */
        TextView textObjectPartA =
                (TextView)findViewById(R.id.textPartA);
        TextView textObjectPartB =
                (TextView)findViewById(R.id.textPartB);
        buttonObjectChoice1 =
                (Button)findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 =
                (Button)findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 =
                (Button)findViewById(R.id.buttonChoice3);

        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);

//which button receives which answer, at this stage is arbitrary.
        buttonObjectChoice1.setText("" + correctAnswer);
        buttonObjectChoice2.setText("" + wrongAnswer1);
        buttonObjectChoice3.setText("" + wrongAnswer2);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);


    } //onCreate ends here

@Override
    public void onClick(View view) {
    //declare a new int to be used in all the cases
    int answerGiven = 0;
    switch (view.getId()) {

        case R.id.buttonChoice1:
            answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());
            answerChecker(answerGiven);
            break;
        case R.id.buttonChoice2:
            //button2 stuff
            answerChecker(answerGiven);
            break;
        case R.id.buttonChoice3:
            //button3 stuff
            answerChecker(answerGiven);
            break;
    }
}

    private void answerChecker(int answerGiven) {
        if(answerGiven == correctAnswer){
            Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_LONG).show();

    } else{
            Toast.makeText(getApplicationContext(),"Sorry that's wrong", Toast.LENGTH_LONG).show();
        }


    }


}
