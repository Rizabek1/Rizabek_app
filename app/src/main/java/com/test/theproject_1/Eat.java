package com.test.theproject_1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Eat extends AppCompatActivity {
    private ImageView eatImgs;
    private TextView eatNames;
    public ImageView back1;
    public ImageView next;
    private MediaPlayer eatSounds;

    Array array  = new Array(); // Для создания объекта Array
    int counter = 0; // Число показывает индекс картины

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.eat);

        eatImgs = (ImageView) findViewById(R.id.eatImgs);
        eatNames = findViewById(R.id.eatNames);
        eatSounds = MediaPlayer.create(this, R.raw.pizza);
        back1 = (ImageView) findViewById(R.id.back1);
        next = (ImageView) findViewById(R.id.next);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        imageClick();
        back1();
        next();
    }

    public void imageClick() {
        eatImgs.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay(eatSounds);
                    }


                }
        );
    }

    public void soundPlay(MediaPlayer sound) {
        sound.start();
    }

    public void back1() {
        if (counter == 0) {
            Intent intent = new Intent(Eat.this, Foods.class);
        } else {
            try {
                eatImgs.setImageResource(array.eatImgs[--counter]);
                eatNames.setText(array.eatNames[--counter]);
                eatSounds.setAudioSessionId(array.eatSounds[--counter]);
            } catch (Exception e) {

            }
        }
    }


    public void next() {
        try {
            counter++;
            eatImgs.setImageResource(array.eatImgs[counter]);
            eatNames.setText(array.eatNames[counter]);
            eatSounds.setAudioSessionId(array.eatSounds[counter]);








        } catch (Exception e) {

        }
    }
}

