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

public class Professions extends AppCompatActivity {
    private ImageView professionImg;
    private TextView professionName;
    public ImageView back1;
    public ImageView next;
    private MediaPlayer professionSound;

    Array array  = new Array(); // Для создания объекта Array
    int counter = 0; // Число показывает индекс картины

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
       setContentView(R.layout.professions);

        professionImg = (ImageView) findViewById(R.id.professionImg);
       professionName = findViewById(R.id.professionName);
       professionSound = MediaPlayer.create(this, R.raw.doctor);
        back1 = (ImageView) findViewById(R.id.back1);
        next = (ImageView) findViewById(R.id.next);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


      imageClick();
        back1();
        next();
    }

    public void imageClick() {
      professionImg.setOnClickListener(
             new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay(professionSound);
              }


            }
      );
    }

   public void soundPlay(MediaPlayer sound) {
      sound.start();
    }

    public void back1() {
        if (counter == 0) {
            Intent intent = new Intent(Professions.this, Words.class);
        } else {
            try {
                professionImg.setImageResource(array.professionImgs[--counter]);
                professionName.setText(array.professionNames[--counter]);
                professionSound.setAudioSessionId(array.professionSounds[--counter]);
            } catch (Exception e) {

            }
        }
    }


    public void next() {
        try {
            counter++;
            professionImg.setImageResource(array.professionImgs[counter]);
            professionName.setText(array.professionNames[counter]);
            professionSound.setAudioSessionId(array.professionSounds[counter]);

           






        } catch (Exception e) {

        }
    }
}

