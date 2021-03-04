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

public class Vegetables extends AppCompatActivity {
    private ImageView vegImgs;
    private TextView vegNames;
    public ImageView back1;
    public ImageView next;
    private MediaPlayer vegSounds;

    Array array  = new Array(); // Для создания объекта Array
    int counter = 0; // Число показывает индекс картины

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetables);

        vegImgs = (ImageView) findViewById(R.id.vegImgs);
        vegNames = findViewById(R.id.vegNames);
        vegSounds = MediaPlayer.create(this, R.raw.pepper);
        back1 = (ImageView) findViewById(R.id.back1);
        next = (ImageView) findViewById(R.id.next);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        imageClick();
        back1();
        next();
    }

    public void imageClick() {
        vegImgs.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay(vegSounds);
                    }


                }
        );
    }

    public void soundPlay(MediaPlayer sound) {
        sound.start();
    }

    public void back1() {
        if (counter == 0) {
            Intent intent = new Intent(Vegetables.this, Foods.class);
        } else {
            try {
                vegImgs.setImageResource(array.vegImgs[--counter]);
                vegNames.setText(array.vegNames[--counter]);
                vegSounds.setAudioSessionId(array.vegSounds[--counter]);
            } catch (Exception e) {

            }
        }
    }


    public void next() {
        try {
            counter++;
            vegImgs.setImageResource(array.vegImgs[counter]);
            vegNames.setText(array.vegNames[counter]);
            vegSounds.setAudioSessionId(array.vegSounds[counter]);








        } catch (Exception e) {

        }
    }
}

