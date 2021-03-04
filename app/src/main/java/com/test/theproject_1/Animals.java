package com.test.theproject_1;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Animals extends AppCompatActivity {
    private ImageView animalImg;
    private TextView animalName;
    public ImageView back1;
    public ImageView next;
    private MediaPlayer animalSound;

    Array array  = new Array(); // Для создания объекта Array
    int counter = 0; // Число показывает индекс картины

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.animals);

        animalImg = (ImageView) findViewById(R.id.animalImg);
       animalName = findViewById(R.id.animalName);
        animalSound = MediaPlayer.create(this, R.raw.bear);
        back1 = (ImageView) findViewById(R.id.back1);
        next = (ImageView) findViewById(R.id.next);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


      imageClick();
        back1();
        next();
    }

    public void imageClick() {
      animalImg.setOnClickListener(
             new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay(animalSound);
              }


            }
      );
    }

   public void soundPlay(MediaPlayer sound) {
      sound.start();
    }

    public void back1() {
        if (counter == 0) {
            Intent intent = new Intent(Animals.this, Words.class);
        } else {
            try {
                animalImg.setImageResource(array.animalImages[--counter]);
                animalName.setText(array.numNames[--counter]);
                animalSound.setAudioSessionId(array.animalSounds[--counter]);
            } catch (Exception e) {

            }
        }
    }


    public void next() {
        try {
            counter++;
            animalImg.setImageResource(array.animalImages[counter]);
            animalName.setText(array.animalNames[counter]);
            animalSound.setAudioSessionId(array.animalSounds[counter]);

           






        } catch (Exception e) {

        }
    }
}

