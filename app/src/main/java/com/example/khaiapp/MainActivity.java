package com.example.khaiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.ArrayList;


/*
*
* Android layouts handling(creating, changing layout)
*
*
* @ author: Vinchester
* @ from: 27/03/2023
*
* */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*
    *
    * Changing current layout to selection.xml,
    *  adding buttons(in  next versions "subjects" variable
    *  will receive List of subjects from dataHandling.getSubjects()
    *
    * @ author: Vinchester
    * @ version: 1.0
    * @ from: 27/032023
    *
    * */
    public void setSelectionView(View view) {
        setContentView(R.layout.selection);
        LinearLayout buttonsContainer = findViewById(R.id.buttons_container);
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Mathemactics");
        subjects.add("English");
        subjects.add("Algorithms");
        subjects.add("UNIX");

        /*
        * Loop, where we add buttons onto selection.xml
        * */

        for(int i =0; i < subjects.size();i++){
            Button button = new Button(this);
            String buttonText = subjects.get(i);
            button.setText(buttonText);
            buttonsContainer.addView(button);
        }

    }

    /*
    *
    * Changing current layout to activity_main.xml
    *
    * */

    public void setMainView(View view){
        setContentView(R.layout.activity_main);
    }
}