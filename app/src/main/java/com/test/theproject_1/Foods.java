package com.test.theproject_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Foods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foods);

        //deploy the window in full screen START
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            //deploy the window in full screen END


        ImageView main_fruitImg = (ImageView)findViewById(R.id.main_fruitImg);
        main_fruitImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent( Foods.this, Fruits.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageView main_vegImg = (ImageView)findViewById(R.id.main_vegImg);
        main_vegImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent( Foods.this, Vegetables.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageView main_Sandwich = (ImageView)findViewById(R.id.main_Sandwich);
        main_Sandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent( Foods.this, Eat.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });




    }
}
