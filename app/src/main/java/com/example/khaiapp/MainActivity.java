package com.example.khaiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.khaiapp.dataHandling.dataHandling;


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
    * @ from: 27/03/2023
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
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setMainView(buttonText);
                }
            });
        }

    }

    /*
    *
    * Changing current layout to activity_main.xml
    *
    * @ author: Vinchester
    * @ version: 1.0
    * @ from: 28/04/2023
    * */

    public void setMainView(String subjectName){
        setContentView(R.layout.activity_main);

        List<List<String>> tasks = dataHandling.testGetSubjectTasks(subjectName);

        /*
        * Loop, where we add tasks onto activity_main.xml
        * */

        for (int i = 0; i < tasks.size();i++){
            LinearLayout tasksContainer = findViewById(R.id.tasks_container);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(20, 20, 20, 20);
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.setBackgroundColor(0xFFBCBCBC);

            TextView taskNameTextView = new TextView(this);
            RelativeLayout.LayoutParams taskNameTextViewParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            taskNameTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            taskNameTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            taskNameTextView.setLayoutParams(taskNameTextViewParams);
            taskNameTextView.setText(tasks.get(i).get(0));
            taskNameTextView.setTextColor(0xFF2B2B2B);
            taskNameTextView.setTextSize(35);
            taskNameTextView.setPaddingRelative(0, 20, 0, 0);
            taskNameTextView.setId(View.generateViewId());

            TextView taskThemeTextView = new TextView(this);
            RelativeLayout.LayoutParams taskThemeTextViewParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            taskThemeTextViewParams.addRule(RelativeLayout.BELOW, taskNameTextView.getId());
            taskThemeTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            taskThemeTextView.setLayoutParams(taskThemeTextViewParams);
            taskThemeTextView.setText(String.format("Theme: %s", tasks.get(i).get(1)));
            taskThemeTextView.setTextColor(0xFF2B2B2B);
            taskThemeTextView.setTextSize(30);
            taskThemeTextView.setPaddingRelative(0, 0, 0, 0);
            taskThemeTextView.setId(View.generateViewId());

            TextView linkTextView = new TextView(this);
            RelativeLayout.LayoutParams linkTextViewParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            linkTextViewParams.addRule(RelativeLayout.BELOW, taskThemeTextView.getId());
            linkTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            linkTextView.setLayoutParams(linkTextViewParams);
            linkTextView.setText(String.format("Link: %s", tasks.get(i).get(2)));
            linkTextView.setTextColor(0xFF2B2B2B);
            linkTextView.setTextSize(30);
            linkTextView.setPaddingRelative(0, 0, 0, 0);

            relativeLayout.addView(taskNameTextView);
            relativeLayout.addView(taskThemeTextView);
            relativeLayout.addView(linkTextView);

            tasksContainer.addView(relativeLayout);
        }


    }
}