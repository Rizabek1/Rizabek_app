package com.test.theproject_1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class One extends AppCompatActivity {
    private ImageView numImg;
    private ImageView numName;
    private ImageView back1;
    private ImageView next;
    private MediaPlayer numSound;

    Array array  = new Array(); // Для создания объекта Array
    int counter = 0; // Число показывает индекс картины

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);
        numImg = (ImageView) findViewById(R.id.numImg);
        numName = (ImageView) findViewById(R.id.numName);
        numSound = MediaPlayer.create(this, R.raw.num1);
        back1 = (ImageView) findViewById(R.id.back1);
        next = (ImageView) findViewById(R.id.next);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        imageClick();
        back1();
        next();
    }

    public void imageClick() {
        numImg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay(numSound);
                    }


                }
        );
    }

    public void soundPlay(MediaPlayer sound) {
        sound.start();
    }

    public void back1() {
        if (counter == 0) {
            Intent intent = new Intent(One.this, MainActivity.class);
        } else {
            try {
                numImg.setImageResource(array.numImages[--counter]);
                numName.setImageResource(array.numNames[--counter]);
                numSound.setAudioSessionId(array.numSounds[--counter]);
            } catch (Exception e) {

            }
        }
    }


    public void next() {
        try {
            counter++;
            numImg.setImageResource(array.numImages[counter]);
            numName.setImageResource(array.numNames[counter]);
            numSound.setAudioSessionId(array.numSounds[counter]);








        } catch (Exception e) {

        }
    }
}

