package com.test.theproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Words extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_activity);

        //deploy the window in full screen START
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            //deploy the window in full screen END


        ImageView myTiger = (ImageView)findViewById(R.id.myTiger);
        myTiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent( Words.this, Animals.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageView main_professionImg = (ImageView)findViewById(R.id.main_professionImg);
        myTiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent( Words.this, Professions.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageView main_familyImg = (ImageView)findViewById(R.id.main_familyImg);
        myTiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent( Words.this, Animals.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageView main_foodImg = (ImageView)findViewById(R.id.main_foodImg);
        main_foodImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent( Words.this, Foods.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });


    }
}
