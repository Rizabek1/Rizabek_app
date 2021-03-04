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

public class Fruits extends AppCompatActivity {
    private ImageView fruitImgs;
    private TextView fruitNames;
    public ImageView back1;
    public ImageView next;
    private MediaPlayer fruitSounds;

    Array array  = new Array(); // Для создания объекта Array
    int counter = 0; // Число показывает индекс картины

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
       setContentView(R.layout.fruits);

        fruitImgs = (ImageView) findViewById(R.id.fruitImgs);
        fruitNames = findViewById(R.id.fruitNames);
        fruitSounds = MediaPlayer.create(this, R.raw.apple);
        back1 = (ImageView) findViewById(R.id.back1);
        next = (ImageView) findViewById(R.id.next);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


      imageClick();
        back1();
        next();
    }

    public void imageClick() {
        fruitImgs.setOnClickListener(
             new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay(fruitSounds);
              }


            }
      );
    }

   public void soundPlay(MediaPlayer sound) {
      sound.start();
    }

    public void back1() {
        if (counter == 0) {
            Intent intent = new Intent(Fruits.this, Foods.class);
        } else {
            try {
                fruitImgs.setImageResource(array.fruitImgs[--counter]);
                fruitNames.setText(array.fruitNames[--counter]);
                fruitSounds.setAudioSessionId(array.fruitSounds[--counter]);
            } catch (Exception e) {

            }
        }
    }


    public void next() {
        try {
            counter++;
            fruitImgs.setImageResource(array.fruitImgs[counter]);
            fruitNames.setText(array.fruitNames[counter]);
            fruitSounds.setAudioSessionId(array.fruitSounds[counter]);

           






        } catch (Exception e) {

        }
    }
}

