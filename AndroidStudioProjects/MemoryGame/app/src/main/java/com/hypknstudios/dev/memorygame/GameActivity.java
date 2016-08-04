package com.hypknstudios.dev.memorygame;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private SoundPool soundPool;
    int sample1= -1;
    int sample2 = -1;
    int sample3 = -1;
    int sample4 = -1;
    TextView textScore;
    TextView textDifficulty;
    TextView textWatchGo;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button buttonReplay;
    int difficultyLevel = 3;
    int[] sequenceToCopy = new int[100];
    private Handler myHandler;
    private boolean playSequence = false;
    int elementToPlay = 0;
    private int playerResponses;
    private int playerScore;
    boolean isResponding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        try{
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;

            descriptor = assetManager.openFd("sample1.ogg");
            sample1 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("sample2.ogg");
            sample2 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("sample3.ogg");
            sample3 = soundPool.load(descriptor, 0);
        } catch(IOException e) {

        }

        //Reference all the elements of the UI
        textScore = (TextView)findViewById(R.id.textScore);
        textScore.setText("Score: " + playerScore);
        textDifficulty = (TextView)findViewById(R.id.textDifficulty);
        textDifficulty.setText("Level: " + difficultyLevel);
        textWatchGo = (TextView)findViewById(R.id.textWatchGo);

        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        buttonReplay = (Button)findViewById(R.id.buttonReplay);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        buttonReplay.setOnClickListener(this);

        myHandler = new Handler() {
            public void handleMessage(Message msg){
                if(playSequence){

                }
                myHandler.sendEmptyMessageDelayed(0, 900);
            }
        };
        myHandler.sendEmptyMessage(0);

    }

    @Override
    public void onClick(View view) {

    }

    public void createSequence(){
        Random randInt = new Random();
        int ourRandom;
        for(int i = 0; i< difficultyLevel; i++){
            ourRandom = randInt.nextInt(4);
            ourRandom++;
            //Save number to array
            sequenceToCopy[i] = ourRandom;
        }
    }

    public void playASequence(){
        createSequence();
        isResponding = false;
        elementToPlay = 0;
        playerResponses = 0;
        textWatchGo.setText("WATCH!");
        playSequence = true;
    }
    
}

